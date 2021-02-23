package Entities;

import java.time.LocalDate;

public class Medicine {


    private int id;
    private String name;
    private int price;
    private LocalDate localdate;
    private String manufacturer;
    private int weight;

    public Medicine(String name, int price, String manufacturer, int weight){}

    public Medicine(int id, String name, int price, LocalDate localdate, String manufacturer, int weight) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.localdate = localdate;
        this.manufacturer = manufacturer;
        this.weight = weight;
    }

    public Medicine(String name, int price, LocalDate localdate, int weight) {
        this.name = name;
        this.price = price;
        this.localdate = localdate;
        this.weight = weight;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getLocaldate() {
        return localdate;
    }

    public void setLocaldate(LocalDate localdate) {
        this.localdate = localdate;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "id = " + id + ", name = " + name + ", price = " + price
                + " Rub " + ", localdate = " + localdate + ", manufacturer = "
                + manufacturer + ", weight = " + weight + " g ";
    }



}