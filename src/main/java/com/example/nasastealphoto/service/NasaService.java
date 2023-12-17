package com.example.nasastealphoto.service;

import com.example.nasastealphoto.exception.NasaUrlProcessingException;
import com.example.nasastealphoto.model.Camera;
import com.example.nasastealphoto.model.Picture;
import com.example.nasastealphoto.util.UrlCreator;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
public class NasaService {
    public static final String PHOTOS = "photos";
    public static final String CAMERA = "camera";
    public static final String ID = "id";
    public static final String IMG_SRC = "img_src";
    public static final String NAME = "name";
    private final RestTemplate restTemplate;
    private final CameraService cameraService;
    private final UrlCreator urlCreator;

    @Transactional
    public void saveData(String sol) {
        Map<Long, Camera> cameras = collectData(sol);
        cameras.values().forEach(cameraService::saveCamera);
    }

    private Map<Long, Camera> collectData(String sol) {
        Map<Long, Camera> camerasMap = new HashMap<>();
        String url = urlCreator.getUrl(sol);

        JsonNode node = restTemplate.getForObject(url, JsonNode.class);
        JsonNode photos = Optional.ofNullable(node)
                .stream()
                .map(n -> n.get(PHOTOS))
                .findFirst()
                .orElseThrow(() -> new NasaUrlProcessingException(
                        String.format("Can't get photos from url: %s", url)));

        StreamSupport.stream(photos.spliterator(), false)
                .forEach(photo -> processPhoto(camerasMap, photo));
        return camerasMap;
    }

    private void processPhoto(Map<Long, Camera> cameras, JsonNode photo) {
        Picture picture = createPicture(photo);

        JsonNode jsonCamera = photo.get(CAMERA);
        long cameraNasaId = jsonCamera.get(ID).asLong();
        Camera cameraFromMap = cameras.get(cameraNasaId);
        if (cameraFromMap == null) {
            Camera camera = new Camera();
            camera.setName(jsonCamera.get(NAME).asText());
            camera.setNasaId(cameraNasaId);
            camera.addPicture(picture);
            cameras.put(camera.getNasaId(), camera);
        } else {
            cameraFromMap.addPicture(picture);
            cameras.put(cameraFromMap.getNasaId(), cameraFromMap);
        }
    }

    private Picture createPicture(JsonNode photo) {
        Picture picture = new Picture();
        picture.setImgSrc(photo.get(IMG_SRC).asText());
        picture.setNasaId(photo.get(ID).asLong());
        return picture;
    }
}

