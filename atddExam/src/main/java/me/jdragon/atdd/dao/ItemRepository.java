package me.jdragon.atdd.dao;

import me.jdragon.atdd.vo.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {
    private Map<Integer, Item> items = new HashMap<>();

    public Item findById(int itemId) {
        if (!items.containsKey(itemId)) {
            items.put(itemId, new Item(itemId,"READY"));
        }
        return items.get(itemId);
    }

    public void save(Item item) {
        items.put(item.getId() , item);
    }


}
