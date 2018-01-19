package com.deedee.apigateway.pagingservice;

import com.deedee.apigateway.model.Data;
import com.deedee.apigateway.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class PagingService {

    static final int ITEM = 5;
    public HashMap<String, Product> Paging = new HashMap<String, Product>();

    public HashMap<String, Product> Paging(String id) {

        int page = Integer.parseInt(id);
        int Index = (page -1)*ITEM;
        int Total = Data.product.size()%ITEM==0?Data.product.size()/ITEM:Data.product.size()/ITEM + 1;
        Object[] keys = Data.product.keySet().toArray();

        if(page > 0 && page < Total + 1){

            if(page == Total){

                for(int i = Index; i < Data.product.size(); i++){

                    Paging.put(Data.product.get(keys[i]).getId(), Data.product.get(keys[i]));
                }
            }
            else{

                for(int i = Index; i < Index + ITEM; i++){

                    Paging.put(Data.product.get(keys[i]).getId(), Data.product.get(keys[i]));
                }
            }
        }

        return Paging;
    }
}
