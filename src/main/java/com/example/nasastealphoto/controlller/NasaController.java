package com.example.nasastealphoto.controlller;

import com.example.nasastealphoto.service.NasaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class NasaController {

    private final NasaService nasaService;

    @PostMapping("/pictures/steal")
    public void stealPictures(@RequestBody RequestDto dto) {
        nasaService.saveData(dto.sol());
    }
}

record RequestDto(String sol) {
}
