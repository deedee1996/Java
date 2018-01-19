package com.deedee.apigateway.controller;

import com.deedee.apigateway.model.Product;
import com.deedee.apigateway.register.ServiceRegister;
import org.springframework.web.bind.annotation.*;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/api-gateway")
public class GatewayController {

    ServiceRegister serviceRegister = new ServiceRegister();

    @RequestMapping(value = "", method = {RequestMethod.GET, RequestMethod.PUT, RequestMethod.POST, RequestMethod.DELETE})

    public HashMap<String, Product> Index(@RequestParam("id") String id,
                              @RequestParam(value = "data", required = false) String[] param,
                              @RequestBody(required = false) Product product
                         )

            throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, UnsupportedEncodingException {

        if(param == null){

             param = new String[]{""};
        }

        Class<?> c = Class.forName(ServiceRegister.Service.get(id).getName());
        Object ob = c.newInstance();
        Method method = c.getMethod(ServiceRegister.Service.get(id).getMethod(), ServiceRegister.Service.get(id).getParam());

        if(product == null){
            HashMap<String, Product> dt = (HashMap<String, Product>) method.invoke(ob, param);
            return dt;

        }

        HashMap<String, Product> dt = (HashMap<String, Product>) method.invoke(ob, product);
        return dt;
    }
}
