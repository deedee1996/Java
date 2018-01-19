package com.deedee.apigateway.searchservice;

import com.deedee.apigateway.model.Data;
import com.deedee.apigateway.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class SearchService {

    HashMap<String, Product> Search = new HashMap<String, Product>();
    Object[] keys = Data.product.keySet().toArray();

    public HashMap<String, Product> Search(String q) {

        for(int i = 0; i < Data.product.size(); i++){

            if(Data.product.get(keys[i]).getId().contains(q) || Data.product.get(keys[i]).getName().contains(q)){

                Search.put(Data.product.get(keys[i]).getId(), Data.product.get(keys[i]));
            }

        }

        return Search;
    }
}
