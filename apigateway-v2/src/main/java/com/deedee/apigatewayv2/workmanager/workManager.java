package com.deedee.apigatewayv2.workmanager;

import com.deedee.apigatewayv2.Interface.IdoWork;
import com.deedee.apigatewayv2.model.Product;
import com.deedee.apigatewayv2.serviceregister.ServiceRegister;
import java.util.HashMap;

public class workManager {

    private IdoWork _iwork;

    public workManager(String name) throws IllegalAccessException, InstantiationException, ClassNotFoundException {

        _iwork = (IdoWork)  ServiceRegister.LoadClass(name);

    }

    public HashMap<String, Product> getWork(Object... data){

        return _iwork.doWork(data);
    }
}
