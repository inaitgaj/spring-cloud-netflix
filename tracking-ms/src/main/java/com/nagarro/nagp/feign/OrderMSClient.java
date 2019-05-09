package com.nagarro.nagp.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "order-ms")
public interface OrderMSClient {
	@RequestMapping(value = "/", method = RequestMethod.GET)
	String printOrderMS();
}
