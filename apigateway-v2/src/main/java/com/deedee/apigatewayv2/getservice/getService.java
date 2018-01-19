package com.deedee.apigatewayv2.getservice;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Data;
import com.deedee.apigatewayv2.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class getService implements IdoWork {

    public HashMap<String, Product> getData = new HashMap<>();

    @Override
    public HashMap<String, Product> doWork(Object... param) {

        getData.clear();

       if(param.getClass().isArray()){

           String[] data = (String[]) param[0];

               if(data[0] == ""){

                   return Data.product;
               }
               else {

                   getData.put(Data.product.get(data[0]).getId(), Data.product.get(data[0]));
                   getData.put(Data.product.get(data[1]).getId(), Data.product.get(data[1]));
               }
           }

       return getData;

    }
}
