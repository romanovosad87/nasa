package com.example.nasastealphoto.repository;

import com.example.nasastealphoto.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> {

}
