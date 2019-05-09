package com.nagarro.nagp.mq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderSource {

	@Output("orderExchangeChannel")
	MessageChannel orderExchange();
}
