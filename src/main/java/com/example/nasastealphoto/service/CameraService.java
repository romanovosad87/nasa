package com.example.nasastealphoto.service;

import com.example.nasastealphoto.model.Camera;
import com.example.nasastealphoto.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CameraService {

    private final CameraRepository cameraRepository;

    @Transactional
    public void saveCamera(Map<Long, Camera> camerasMap) {
        cameraRepository.saveAll(camerasMap.values());
    }
}
