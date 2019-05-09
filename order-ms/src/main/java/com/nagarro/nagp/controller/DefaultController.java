package com.nagarro.nagp.controller;

import com.netflix.discovery.converters.Auto;
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

    @Autowired
    private Registration registration;

    @Value("${msg:unknown}")//taken from application.yaml, can also be overriden by config server.
    private String msg;

    @RequestMapping(path =  "/", method = RequestMethod.GET)
    public String printServiceB(){
        return registration.getServiceId() + " (" + registration.getHost() + ":"
                +registration.getPort() + ")" + "\n Message= " + msg;
    }
}
