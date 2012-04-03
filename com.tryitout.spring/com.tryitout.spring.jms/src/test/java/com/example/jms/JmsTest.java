package com.example.jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.OrderService;

public class JmsTest {
    public static void main(String[] args) {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ioc/backend/applicationContext.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");
        
        for(int i =1; i<=5; i++)
            orderService.sendOrder(1+i, 10.0D+i);
    }
}