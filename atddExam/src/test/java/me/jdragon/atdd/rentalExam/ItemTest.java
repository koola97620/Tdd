package me.jdragon.atdd.rentalExam;

import me.jdragon.atdd.vo.AlreadyRentItemException;
import me.jdragon.atdd.vo.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class ItemTest {

    @Test
    public void checkStatus() {
        Item item = new Item(111, "RENT");
        assertThatExceptionOfType(AlreadyRentItemException.class).isThrownBy( () -> item.checkStatus());
    }
}
