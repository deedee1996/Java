package com.deedee.apigatewayv2.searchservice;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Data;
import com.deedee.apigatewayv2.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class searchService implements IdoWork {

    public HashMap<String, Product> Search = new HashMap<>();
    @Override
    public HashMap<String, Product> doWork(Object... param) {

        Search.clear();

        if(param.getClass().isArray()){

            String[] data = (String[]) param[0];

            Object[] keys = Data.product.keySet().toArray();

            for(int i = 0 ; i< keys.length; i++){

                if(Data.product.get(keys[i]).getId().contains((CharSequence) data[0]) || Data.product.get(keys[i]).getName().contains((CharSequence) data[0])){

                    Search.put(Data.product.get(keys[i]).getId(), Data.product.get(keys[i]));

                }
            }

        }

        return Search;
    }
}
