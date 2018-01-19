package com.deedee.apigatewayv2.test;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.HashMap;

@Service
public class Test implements IdoWork {

    HashMap<String, Product> test = new HashMap<>();
    @Override
    public HashMap<String, Product> doWork(Object... data) {

        String dt = (String) data[2];

        Product p = null;
        try {

            p = new ObjectMapper().readValue(dt, Product.class);

        } catch (IOException e) {
            e.printStackTrace();
        }

        test.put(p.getId(), p);

        return test;
    }
}
