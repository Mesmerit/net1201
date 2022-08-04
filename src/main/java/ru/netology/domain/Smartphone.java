package ru.netology.domain;


public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone(int id, String title, int price, String manufacturer) {
        super(id, title, price);
        this.manufacturer = manufacturer;
    }

    @Override
    public boolean matches (String query){
        if (title.contains(query)) {
            return  true;
        }
        if (manufacturer.contains(query)){
            return true;
        }
        return false;
    }
}
