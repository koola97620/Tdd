package me.jdragon.atdd.rentalExam;

import me.jdragon.atdd.dao.ItemRepository;
import me.jdragon.atdd.vo.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = ItemRepository.class)
public class ItemRepositoryTest {
    private ItemRepository itemRepository;

    @BeforeEach
    public void setUp() {
        itemRepository = new ItemRepository();
        Item item = new Item(1,"READY");
        Item item2 = new Item(5,"READY");
        itemRepository.save(item);
        itemRepository.save(item2);
    }

    @Test
    public void findById() {
        Item persistItem = itemRepository.findById(5);
        assertThat(persistItem.getId()).isEqualTo(5);
    }

    @Test
    public void commitTest() {
        System.out.println();
    }

    @Test
    public void repoTest(){}
    @Test
    public void repoTest2(){}

}
