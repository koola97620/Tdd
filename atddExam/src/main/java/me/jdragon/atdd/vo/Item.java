package me.jdragon.atdd.vo;

public class Item {
    private Integer id;
    private String status;

    public Item(Integer id, String status) {
        this.id = id;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void checkStatus() {
        if (status.equals("RENT")) {
            throw new AlreadyRentItemException();
        }
    }
}
