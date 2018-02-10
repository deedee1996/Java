package com.deedee.apigatewayv2.model;

import java.util.HashMap;

public class Data {

    public static HashMap<String, Product> product = new HashMap<>();

    static{

        product.put("P1", new Product("P1", "PVC", 20));
        product.put("P2", new Product("P2", "PCVC", 230));
        product.put("P3", new Product("P3", "PDVC", 2530));
        product.put("P4", new Product("P4", "PEVC", 320));
        product.put("P5", new Product("P5", "PGVC", 240));
        product.put("P6", new Product("P6", "PSVC", 220));
        product.put("P06", new Product("P06", "PSVC", 220));
        product.put("P56", new Product("P76", "PSVC", 220));
        product.put("P96", new Product("P56", "PSVC", 220));
        product.put("P76", new Product("P36", "PSVC", 220));
        product.put("P66", new Product("P26", "PSVC", 220));

    }
}
