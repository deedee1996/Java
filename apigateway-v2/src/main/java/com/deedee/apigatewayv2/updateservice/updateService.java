package com.deedee.apigatewayv2.updateservice;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Data;
import com.deedee.apigatewayv2.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class updateService implements IdoWork {
    @Override
    public HashMap<String, Product> doWork(Object... param) {

        Product data = (Product) param[1];

        Data.product.get(data.getId()).setName(data.getName());
        Data.product.get(data.getId()).setQuantity(data.getQuantity());

        return Data.product;
    }
}
