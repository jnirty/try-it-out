package com.example.event;

import org.springframework.context.ApplicationEvent;
/**
 * http://static.springsource.org/spring/docs/3.0.x/spring-framework-reference/html/beans.html#context-functionality-events
 *
 */
public class HomeNavigatedEvent extends ApplicationEvent  {
	private String message;
	public HomeNavigatedEvent(Object source, String message) {
		super(source);
		this.message = message;
	}
	
	public String getMessage(){
		return message;
	}

}
