package com.example.nasastealphoto.dto.mapper;

import com.example.nasastealphoto.dto.CameraResponseDto;
import com.example.nasastealphoto.model.Camera;
import org.springframework.stereotype.Component;

@Component
public class CameraMapper {

    public CameraResponseDto toDto(Camera camera) {
        CameraResponseDto dto = new CameraResponseDto();
        dto.setId(camera.getId());
        dto.setName(camera.getName());
        dto.setNasaId(camera.getNasaId());
        dto.setCreatedAt(camera.getCreatedAt());
        return dto;
    }
}
