package com.deedee.apigatewayv2.workmanager;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.addservice.addService;
import com.deedee.apigatewayv2.deleteservice.deleteService;
import com.deedee.apigatewayv2.getservice.getService;
import com.deedee.apigatewayv2.model.Product;
import com.deedee.apigatewayv2.searchservice.searchService;
import com.deedee.apigatewayv2.test.Test;
import com.deedee.apigatewayv2.updateservice.updateService;
import java.util.HashMap;


public class workManager {

    static HashMap<String, Object> service = new HashMap<>();

    static {

        service.put("get", new getService());
        service.put("add", new addService());
        service.put("delete", new deleteService());
        service.put("update", new updateService());
        service.put("search", new searchService());
        service.put("test", new Test());
    }

    private IdoWork _iwork;

    public workManager(String name){

        _iwork = (IdoWork) service.get(name);

    }

    public HashMap<String, Product> getWork(Object... data){

        return _iwork.doWork(data);
    }
}
