package me.jdragon.atdd.service;

import me.jdragon.atdd.dao.ItemRepository;
import me.jdragon.atdd.dao.RentalRepository;
import me.jdragon.atdd.dto.RentalRequestDto;
import me.jdragon.atdd.vo.Item;
import me.jdragon.atdd.vo.Rental;
import org.springframework.stereotype.Service;

@Service
public class RentalService {

    private RentalRepository rentalRepository;
    private ItemRepository itemRepository;

    public RentalService(RentalRepository rentalRepository , ItemRepository itemRepository) {
        this.rentalRepository = rentalRepository;
        this.itemRepository = itemRepository;
    }

    public Rental createRental(RentalRequestDto requestDto) {
        System.out.println("-==----------------------- requestDto.getItemId() : " + requestDto.getItemId());
        Item persistItem = itemRepository.findById(requestDto.getItemId());
        Rental persistRental = new Rental(requestDto.getDate(), persistItem, "READY");
        return rentalRepository.save(persistRental);
    }
}
