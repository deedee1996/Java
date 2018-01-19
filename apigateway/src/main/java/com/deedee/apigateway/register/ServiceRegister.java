package com.deedee.apigateway.register;

import com.deedee.apigateway.addservice.AddService;
import com.deedee.apigateway.deleteservice.DeleteService;
import com.deedee.apigateway.getservice.GetService;
import com.deedee.apigateway.model.Product;
import com.deedee.apigateway.pagingservice.PagingService;
import com.deedee.apigateway.searchservice.SearchService;
import com.deedee.apigateway.test.TestService;
import com.deedee.apigateway.updateservice.UpdateService;
import java.util.HashMap;

public class ServiceRegister {

    public static HashMap<String, ServiceInfo> Service = new HashMap<>();

    public class ServiceInfo{
        private String Name;
        private String Method;

        private Class<?>[] Param;

        private ServiceInfo(String name, String method, Class<?>... param) {

            Name = name;
            Method = method;
            Param = param;
        }

        public Class<?>[] getParam() {

            return Param;
        }

        public String getName() {
            return Name;
        }

        public void setName(String name) {
            Name = name;
        }

        public String getMethod() {
            return Method;
        }

        public void setMethod(String method) {
            Method = method;
        }
    }
    public ServiceRegister() {

        Service.put("get", new ServiceInfo(GetService.class.getName(), "getData", String.class));
        Service.put("update", new ServiceInfo(UpdateService.class.getName(), "Update", Product.class));
        Service.put("delete", new ServiceInfo(DeleteService.class.getName(), "Delete", String.class));
        Service.put("search", new ServiceInfo(SearchService.class.getName(), "Search", String.class));
        Service.put("paging", new ServiceInfo(PagingService.class.getName(), "Paging", String.class));
        Service.put("add", new ServiceInfo(AddService.class.getName(), "Add", Product.class));
        Service.put("test", new ServiceInfo(TestService.class.getName(), "testData", String.class, String.class));
    }
}
