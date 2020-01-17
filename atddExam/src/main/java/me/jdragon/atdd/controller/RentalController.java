package me.jdragon.atdd.controller;

import me.jdragon.atdd.dto.RentalRequestDto;
import me.jdragon.atdd.dto.RentalResponseDto;
import me.jdragon.atdd.service.RentalService;
import me.jdragon.atdd.vo.Rental;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class RentalController {

    private RentalService rentalService;

    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @PostMapping("/rentals")
    public ResponseEntity createArticles(@RequestBody RentalRequestDto requestDto) {
        Rental rental = rentalService.createRental(requestDto);
        return ResponseEntity.created(URI.create("/rentals" + rental.getId())).body(rental);

    }
}
