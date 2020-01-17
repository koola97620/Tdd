package me.jdragon.atdd.vo;

public class Item {
    private Integer id;
    public Item(Integer id, String ready) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
