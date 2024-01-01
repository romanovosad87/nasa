package com.example.nasastealphoto.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CameraResponseDto {
    private Long id;
    private String name;
    private Long nasaId;
    private LocalDateTime createdAt;
}
