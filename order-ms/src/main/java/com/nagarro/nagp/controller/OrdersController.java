package com.nagarro.nagp.controller;

import com.nagarro.nagp.dto.OrderDTO;
import com.nagarro.nagp.mq.source.OrderSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//for config changes to reflect.
@RefreshScope
@RestController
@RequestMapping(path =  "/orders")
public class OrdersController {

    @Autowired
    OrderSource orderSource;

    @Autowired
    private Registration registration;

    @RequestMapping(method = RequestMethod.POST)
    public String createOrder(@RequestBody OrderDTO order){
        orderSource.orderExchange().send(MessageBuilder.withPayload(order).build());
        System.out.println("received & pushed order ="+ order.toString());
        return "food ordered!";
    }
}
