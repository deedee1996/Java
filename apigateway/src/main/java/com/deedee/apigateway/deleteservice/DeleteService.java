package com.deedee.apigateway.deleteservice;

import com.deedee.apigateway.model.Data;
import com.deedee.apigateway.model.Product;

import java.util.HashMap;

public class DeleteService {

    public HashMap<String, Product> Delete(String id){

         Data.product.remove(id);

         return Data.product;
    }
}
