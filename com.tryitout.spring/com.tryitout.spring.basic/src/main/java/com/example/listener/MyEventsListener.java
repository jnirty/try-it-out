package com.example.listener;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import com.example.event.HomeNavigatedEvent;

public class MyEventsListener implements ApplicationListener<ApplicationEvent> {

	@Override
	public void onApplicationEvent(ApplicationEvent event) {
		System.out.println("Listened event ...." + event.getClass().getName());
		if(event instanceof HomeNavigatedEvent){
			System.out.println("Cought custom event..., message = "+((HomeNavigatedEvent)event).getMessage());
		}
	}

}
