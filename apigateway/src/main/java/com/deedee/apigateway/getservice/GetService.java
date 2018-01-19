package com.deedee.apigateway.getservice;

import com.deedee.apigateway.model.Data;
import com.deedee.apigateway.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class GetService {

    public HashMap<String, Product> data = new HashMap<>();

    public HashMap<String, Product> getData(String id) {

        data.clear();
        if(id == ""){

            return Data.product;
        }
        data.put(Data.product.get(id).getId(), Data.product.get(id));
        return  data;
    }
}
