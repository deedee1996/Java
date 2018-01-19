package com.deedee.apigatewayv2.deleteservice;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Data;
import com.deedee.apigatewayv2.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class deleteService implements IdoWork {

    @Override
    public HashMap<String, Product> doWork(Object... id) {

        Data.product.remove(id[0]);
        return Data.product;
    }
}
