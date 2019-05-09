package com.nagarro.nagp.controller;

import com.nagarro.nagp.hystrix.HystrixWrappedOrderMSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//for config changes to reflect.
@RefreshScope
@RestController
public class DefaultController {

    @Value("${name:unknown}")//taken from application.yaml, can also be overriden by config server.
    private String name;

    @Autowired
    private Registration registration;

    @Autowired
    private HystrixWrappedOrderMSClient hystrixServiceBClient;

    @RequestMapping(path =  "/", method = RequestMethod.GET)
    public String printOrderMSHystrix(){
        return String.format("===>name: %s is working fine \n Service: %s(%s:%s).\n Message from B: %s",
                name, registration.getServiceId(), registration.getHost(), registration.getPort(),
                hystrixServiceBClient.printOrderMS());
    }
}
