package me.jdragon.atdd.rentalExam;


import me.jdragon.atdd.vo.AlreadyRentItemException;
import me.jdragon.atdd.vo.Item;
import me.jdragon.atdd.vo.Rental;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RentalTest {
    @Test
    public void check() {
        assertThatExceptionOfType(AlreadyRentItemException.class).isThrownBy( () -> new Rental("20191127" , new Item(111,"RENT") , "READY"));
    }
}
