package com.deedee.apigateway.updateservice;

import com.deedee.apigateway.model.Data;
import com.deedee.apigateway.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UpdateService {

    public HashMap<String, Product> Update(Product p){

        if(Data.product.get(p.getId()) == null) {

            return Data.product;
        }

        Data.product.get(p.getId()).setName(p.getName());
        Data.product.get(p.getId()).setQuantity(p.getQuantity());

        return Data.product;
    }
}
