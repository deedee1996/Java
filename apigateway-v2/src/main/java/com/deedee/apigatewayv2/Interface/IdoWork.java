package com.deedee.apigatewayv2.Interface;

import com.deedee.apigatewayv2.model.Product;

import java.util.HashMap;

public interface IdoWork {

    public HashMap<String, Product> doWork(Object... data);
}
