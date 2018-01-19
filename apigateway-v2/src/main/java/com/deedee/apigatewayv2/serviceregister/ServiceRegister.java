package com.deedee.apigatewayv2.serviceregister;

import com.deedee.apigatewayv2.addservice.addService;
import com.deedee.apigatewayv2.deleteservice.deleteService;
import com.deedee.apigatewayv2.getservice.getService;
import com.deedee.apigatewayv2.searchservice.searchService;
import com.deedee.apigatewayv2.test.Test;
import com.deedee.apigatewayv2.updateservice.updateService;

import java.util.HashMap;

public  class ServiceRegister {

    private static HashMap<String,String> service = new HashMap<>();

    static {

        service.put("test1", Test.class.getName());
        service.put("add", addService.class.getName());
        service.put("delete", deleteService.class.getName());
        service.put("update", updateService.class.getName());
        service.put("search", searchService.class.getName());
        service.put("get", getService.class.getName());
    }

    public static Object LoadClass(String name) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        Class<?> c = Class.forName(service.get(name));

        Object ob = c.newInstance();

        return ob;
    }
}
