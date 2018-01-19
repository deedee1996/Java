package com.deedee.apigatewayv2.addservice;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Data;
import com.deedee.apigatewayv2.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class addService implements IdoWork {

    @Override
    public HashMap<String, Product> doWork(Object... param) {

        Product data = (Product) param[1];

        if(Data.product.get(data.getId()) == null){
            Data.product.put(data.getId(), data);
        }
        else {

            int newquantity = Data.product.get(data.getId()).getQuantity() + data.getQuantity();
            Data.product.get(data.getId()).setQuantity(newquantity);
        }
        return Data.product;
    }
}
