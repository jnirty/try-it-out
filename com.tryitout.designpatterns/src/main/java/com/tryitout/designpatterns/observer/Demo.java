package com.tryitout.designpatterns.observer;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {

		Observable observable = new Observable();
		observable.subscribe(new Display1());
		observable.subscribe(new Display2());

		observable.updateDisplays();

	}
}

interface Observer {

	public void doSth();
}

class Observable {
	List<Observer> subscribers = new ArrayList<Observer>();

	public void subscribe(Observer observer) {
		subscribers.add(observer);
	}

	public void updateDisplays() {
		for (Observer observer : subscribers) {
			observer.doSth();
		}
	}

	public void unsubscribe(Observer observer) {
		subscribers.remove(observer);
	}
}

class Display1 implements Observer {

	public void doSth() {
		System.out.println("Update display 1");
	}

}

class Display2 implements Observer {

	public void doSth() {
		System.out.println("Update display 2");
	}

}