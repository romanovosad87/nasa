package com.example.nasastealphoto.controlller;

import com.example.nasastealphoto.dto.PictureResponseDto;
import com.example.nasastealphoto.model.Sol;
import com.example.nasastealphoto.service.NasaService;
import com.example.nasastealphoto.service.PictureService;
import com.example.nasastealphoto.service.SolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NasaController {

    public static final String HAVE_BEEN_ALREADY_STOLEN = "All pictures by sol %s have been already stolen";
    public static final String WERE_STOLEN = "Pictures by sol %s were stolen";
    private final NasaService nasaService;
    private final PictureService pictureService;
    private final SolService solService;

    @PostMapping("/pictures/steal")
    public ResponseEntity<String> stealPictures(@RequestBody RequestDto dto) {
        String data = dto.sol();
        Optional<Sol> solByData = solService.getSolByData(data);
        if (solByData.isPresent()) {
            return new ResponseEntity<>(HAVE_BEEN_ALREADY_STOLEN.formatted(data),
                    HttpStatus.CONFLICT);
        } else {
            nasaService.saveData(data);
            solService.saveSol(data);
            return new ResponseEntity<>(WERE_STOLEN.formatted(data), HttpStatus.CREATED);
        }
    }

    @GetMapping("/pictures")
    public ResponseEntity<List<PictureResponseDto>> getAllPictures() {
        List<PictureResponseDto> allPictures = pictureService.getAllPictures();
        return new ResponseEntity<>(allPictures, HttpStatus.OK);
    }
}

record RequestDto(String sol) {
}
