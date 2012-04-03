package com.example.jms;

import javax.annotation.Resource;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.BrokerServiceAware;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.example.service.OrderService;

@ContextConfiguration
public class ServiceOperationsJmsProducerTest extends
		AbstractJUnit4SpringContextTests implements BrokerServiceAware {

	private BrokerService brokerService;

	@Autowired
	OrderService orderService;

	@Test
	public void testProducer() throws Exception {
		try {
			//brokerService.start();

			for (int i = 1; i <= 5; i++)
				orderService.sendOrder(1 + i, 10.0D + i);

		} finally {
			brokerService.stop();
			brokerService.waitUntilStopped();
		}
	}

	@Override
	@Resource
	public void setBrokerService(BrokerService brokerService) {
		this.brokerService = brokerService;
	}
}