package com.example.nasastealphoto.service;

import com.example.nasastealphoto.dto.PictureResponseDto;
import com.example.nasastealphoto.dto.mapper.PictureMapper;
import com.example.nasastealphoto.repository.PictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PictureService {

    private final PictureRepository pictureRepository;
    private final PictureMapper pictureMapper;

    public List<PictureResponseDto> getAllPictures() {
        return pictureRepository.findAll()
                .stream()
                .map(pictureMapper::toDto)
                .toList();
    }
}
