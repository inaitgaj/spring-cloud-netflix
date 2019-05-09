package com.nagarro.nagp.events.consumer;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class OrderEventConsumer {
	@StreamListener(target = Sink.INPUT)
	public void processOrderEvents(String order){
		System.out.println("Order recieved from rabbitMQ : "+order);
	}
}
