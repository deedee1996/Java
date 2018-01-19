package com.deedee.apigateway.test1;

import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;

import java.net.URLEncoder;

public class Test {
    public static void main(String[] args) {
        try {
            String str="{\"name\":\"aaa\",\"soluong\":\"10\"}";
            System.out.println(URLEncoder.encode(str,"UTF-8"));
        }catch (Exception e){

        }

    }
}
