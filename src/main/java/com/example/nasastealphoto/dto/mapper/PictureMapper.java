package com.example.nasastealphoto.dto.mapper;

import com.example.nasastealphoto.dto.CameraResponseDto;
import com.example.nasastealphoto.dto.PictureResponseDto;
import com.example.nasastealphoto.model.Picture;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PictureMapper {

    private final CameraMapper cameraMapper;

    public PictureResponseDto toDto(Picture picture) {
        PictureResponseDto dto = new PictureResponseDto();
        dto.setId(picture.getId());
        dto.setNasaId(picture.getNasaId());
        dto.setImgSrc(picture.getImgSrc());
        dto.setCreatedAt(picture.getCreatedAt());
        CameraResponseDto cameraResponseDto = cameraMapper.toDto(picture.getCamera());
        dto.setCamera(cameraResponseDto);
        return dto;
    }
}
