package com.nagarro.nagp.mq.publisher;

import com.nagarro.nagp.mq.source.OrderSource;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(OrderSource.class)
public class OrderPublisher {


}
