package com.nagarro.nagp.hystrix;

import com.nagarro.nagp.feign.OrderMSClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HystrixWrappedOrderMSClient implements OrderMSClient {

	@Autowired
	private OrderMSClient serviceBClient;

	@HystrixCommand(groupKey = "helloGroup", fallbackMethod = "fallBackCall")
	@Override public String printOrderMS() {
		return serviceBClient.printOrderMS();
	}

	public String fallBackCall(){
		return "FAILED ORDER MS CALL! - Falling Back";
	}
}
