package com.example.nasastealphoto.repository;

import com.example.nasastealphoto.model.Picture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PictureRepository extends JpaRepository<Picture, Long> {
}
