package com.example.ejercicio4;

public class Imagen {
    int id;
    String name;
    String thumb_url;
    float price;
    String provider;
    float delivery;

    public Imagen(int id, String name, String thumb_url, float price, String provider, float delivery){
        this.id = id;
        this.name = name;
        this.thumb_url = thumb_url;
        this.price = price;
        this.provider = provider;
        this.delivery = delivery;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getThumb_url(){
        return thumb_url;
    }

    public void setThumb_url(String thumb_url){
        this.thumb_url = thumb_url;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public float getDelivery() {
        return delivery;
    }

    public void setDelivery(float delivery) {
        this.delivery = delivery;
    }
}
