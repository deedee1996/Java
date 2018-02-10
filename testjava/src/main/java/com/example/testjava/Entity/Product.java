package com.example.testjava.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @Column(name = "productid")
    private int ProductId;

    @Column(name = "productname")
    private String ProductName;

    public String getProductName() {
        return ProductName;
    }
}
