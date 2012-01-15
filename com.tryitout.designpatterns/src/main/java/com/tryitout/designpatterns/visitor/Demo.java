package com.tryitout.designpatterns.visitor;

import java.util.ArrayList;
import java.util.List;

public class Demo {
	public static void main(String[] args) {
		new Car().accept(new Visitor());
	}
}

interface CarElement {

	public void accept(Visitor visitor);
}

class Car implements CarElement {
	private List<CarElement> elements = new ArrayList<CarElement>();

	public Car() {
		elements.add(new Wheel());
		elements.add(new Wheel());
		elements.add(new Wheel());
		elements.add(new Wheel());
		elements.add(new Engine());
	}

	public void accept(Visitor visitor) {
		for (CarElement element : elements) {
			visitor.visit(element);
		}
		visitor.visit(this);
	}

}

class Engine implements CarElement {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}

class Wheel implements CarElement {

	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

}

class Visitor {
	public void visit(CarElement carElement) {

		if (carElement instanceof Engine) {
			System.out.println("Visit engine");
		} else if (carElement instanceof Wheel) {
			System.out.println("Visit wheel");
		} else if(carElement instanceof Car){
			System.out.println("Visit car");
		}
	}
}