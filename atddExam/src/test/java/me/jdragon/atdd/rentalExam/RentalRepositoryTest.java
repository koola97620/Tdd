package me.jdragon.atdd.rentalExam;

import me.jdragon.atdd.dao.RentalRepository;
import me.jdragon.atdd.vo.Item;
import me.jdragon.atdd.vo.Rental;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = RentalRepository.class)
public class RentalRepositoryTest {

    private RentalRepository rentalRepository;

    @BeforeEach
    public void setUp() {
        rentalRepository = new RentalRepository();
    }

    @Test
    public void save() {
        Item item = new Item(110920 , "READY");
        Rental rental = new Rental("20191127" , item, "READY");
        Rental persistRental = rentalRepository.save(rental);

        assertThat(persistRental.getId()).isEqualTo(1);

    }
}
