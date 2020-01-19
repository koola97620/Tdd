package me.jdragon.atdd.vo;

public class Rental {
    private int id;
    private String date;
    private Item item;
    private String status;

    public Rental(int id, String s, Item item, String status) {
        this.id = id;
        this.date = s;
        this.item = item;
        this.status = status;
    }

    public Rental(String date, Item item, String status) {
        item.checkStatus();
        this.date = date;
        this.item = item;
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
