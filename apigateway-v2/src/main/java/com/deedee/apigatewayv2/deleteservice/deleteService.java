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

        String[] data = null;
        if(id.getClass().isArray()){
            
            data  = (String[]) id[0];
            
        }
        Data.product.remove(data[0]);
        return Data.product;
    }
}
