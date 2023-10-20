package com.Helper;

import static com.Helper.HelperClass.ConvertCurrencyPriceToInt;
public class Product {

    public Product(String name, String description, double price){
        this(name,price);
        this.description = description;
    }

    public Product(String price){
        this.price = ConvertCurrencyPriceToInt(price);
    }

    public Product(int price){
        this.price = price;
    }

    public Product(String name, String description, String price){
        this.name = name;
        this.price = ConvertCurrencyPriceToInt(price);
        this.description = description;
    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    private String name;
    private String description;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
