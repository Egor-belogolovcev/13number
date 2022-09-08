package ru.netology;

public class Smartphone extends Product {
    private String manufacture;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String title, int price, String manufacture) {
        super(id, title, price);
        this.manufacture = manufacture;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }


}
