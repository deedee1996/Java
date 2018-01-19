package com.deedee.apigateway.test;


import com.deedee.apigateway.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class TestService{

    static HashMap<String, String> test = new HashMap<>();

    public HashMap<String, String> testData(String id, String id2){

        test.put(id, "haha");
        test.put(id2, "OK");

        return test;
    }
}
