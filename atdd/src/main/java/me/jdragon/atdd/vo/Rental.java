package me.jdragon.atdd.vo;

public class Rental {
    private int id;
    private String date;
    private Item item;
    private String ready;
    private String status;

    public Rental(int id, String s, Item item, String ready) {
        this.id = id;
        this.date = s;
        this.item = item;
        this.status = ready;
    }

    public Rental(String date, Item persistItem, String ready) {
        this.date = date;
        this.item = persistItem;
        this.ready = ready;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Item getItem() {
        return item;
    }

    public String getReady() {
        return ready;
    }

    public String getStatus() {
        return status;
    }
}
