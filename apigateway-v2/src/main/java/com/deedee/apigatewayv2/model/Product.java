package com.deedee.apigatewayv2.model;

public class Product {

    private String Id;
    private String Name;
    private int Quantity;


    public Product(){}

    public Product(String id, String name, int quantity) {
        Id = id;
        Name = name;
        Quantity = quantity;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
