package me.jdragon.atdd.rentalExam;

import me.jdragon.atdd.dao.RentalRepository;
import me.jdragon.atdd.dto.RentalRequestDto;
import me.jdragon.atdd.dao.ItemRepository;
import me.jdragon.atdd.service.RentalService;
import me.jdragon.atdd.vo.Item;
import me.jdragon.atdd.vo.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;

@SpringBootTest(classes = RentalService.class)
public class RentalServiceTest {
    private RentalService rentalService;

    @MockBean
    private RentalRepository rentalRepository;

    @MockBean
    private ItemRepository itemRepository;


    @BeforeEach
    public void setUp() {
        rentalService = new RentalService(rentalRepository, itemRepository);
    }

    @Test
    public void createRental() {
        Item item = new Item(1 , "READY");
        given(itemRepository.findById(anyInt())).willReturn(item);

        RentalRequestDto rentalRequestDto = new RentalRequestDto("20191127" , 1123);
        given(rentalRepository.save(any())).willReturn(new Rental(1,rentalRequestDto.getDate(), item, "READY"));

        Rental persistRental = rentalService.createRental(rentalRequestDto);

        assertThat(persistRental).isNotNull();

    }
}
