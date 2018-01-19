package com.deedee.apigateway.model;

import java.util.HashMap;

public class Data {

    public static HashMap<String, Product> product = new HashMap<>();

    static {
        product.put("AB", new Product("AB", "PVC", 20));
        product.put("B", new Product("B", "PVB", 210));
        product.put("C", new Product("C", "PVA", 220));
        product.put("D", new Product("D", "PVF", 204));
        product.put("E", new Product("E", "PVE", 206));
        product.put("F", new Product("F", "PVD", 290));
        product.put("K", new Product("K", "AAA", 7));
    }
}
