package com.example.nasastealphoto.service;

import com.example.nasastealphoto.model.Camera;
import com.example.nasastealphoto.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CameraService {

    private final CameraRepository cameraRepository;

    public Camera saveCamera(Camera camera) {
        return cameraRepository.save(camera);
    }
}
