package com.example.nasastealphoto.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class PictureResponseDto {
    private Long id;
    private Long nasaId;
    private  String imgSrc;
    private LocalDateTime createdAt;
    private CameraResponseDto camera;
}
