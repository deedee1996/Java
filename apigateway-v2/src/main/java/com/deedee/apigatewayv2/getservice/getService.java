package com.deedee.apigatewayv2.getservice;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Data;
import com.deedee.apigatewayv2.model.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;

@Service
public class getService implements IdoWork {

    private static final int ITEM_PER_SIZE = 5;
    public HashMap<String, Product> getData = new HashMap<>();

    @Override
    public HashMap<String, Product> doWork(Object... param) {

        getData.clear();

        int size = Data.product.size();

        int page = size%ITEM_PER_SIZE==0?size/ITEM_PER_SIZE:size/ITEM_PER_SIZE+1;

        Object[] keys = Data.product.keySet().toArray();

        if(param.getClass().isArray()){

           String[] data = (String[]) param[0];

           int p = Integer.parseInt(data[0]);

               if(data[0] == ""){

                   return Data.product;
               }
               else {
                   if(p > 0 && p < page + 1){

                       if(p == page){

                           for(int i = (p-1)*ITEM_PER_SIZE; i < size; i++){

                               getData.put(Data.product.get(keys[i]).getId(), Data.product.get(keys[i]));

                           }
                       }
                       else{

                           for(int i = (p-1)*ITEM_PER_SIZE; i < ITEM_PER_SIZE*p; i++){

                               getData.put(Data.product.get(keys[i]).getId(), Data.product.get(keys[i]));
                           }

                       }
                   }

               }
           }

        return getData;
    }
}
