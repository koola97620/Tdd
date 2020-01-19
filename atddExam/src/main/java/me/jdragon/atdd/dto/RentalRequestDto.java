package me.jdragon.atdd.dto;

public class RentalRequestDto {
    private String date;
    private int itemId;

    public RentalRequestDto(String date, int itemId) {
        this.date = date;
        this.itemId = itemId;
    }

    public String getDate() {
        return date;
    }

    public int getItemId() {
        return itemId;
    }
}
