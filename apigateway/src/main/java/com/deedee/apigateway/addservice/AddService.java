package com.deedee.apigateway.addservice;

import com.deedee.apigateway.model.Data;
import com.deedee.apigateway.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AddService {

    public HashMap<String, Product> Add(Product p){

        if(Data.product.get(p.getId()) != null){

            int newQuantity = Data.product.get(p.getId()).getQuantity() + p.getQuantity();

            Data.product.get(p.getId()).setQuantity(newQuantity);
        }

        else {

            Data.product.put(p.getId(), p);
        }

        return Data.product;
    }
}
