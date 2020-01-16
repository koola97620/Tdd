package me.jdragon.atdd.dao;

import me.jdragon.atdd.dto.RentalRequestDto;
import me.jdragon.atdd.vo.Rental;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RentalRepository {
    private List<Rental> rentals = new ArrayList<>();

    public Rental save(Rental rental) {
        Rental persistRental = new Rental(rentals.size() + 1, rental.getDate(), rental.getItem(), rental.getStatus());
        rentals.add(persistRental);
        return persistRental;
    }
}
