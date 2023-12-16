package com.example.nasastealphoto.service;

import com.example.nasastealphoto.model.Camera;
import com.example.nasastealphoto.repository.CameraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CameraService {

    private final CameraRepository cameraRepository;

    @Transactional
    public Camera saveCamera(Camera camera) {
        return cameraRepository.save(camera);
    }
}
