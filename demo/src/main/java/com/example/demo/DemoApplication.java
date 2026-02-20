package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//		Car car1 = context.getBean(Car.class);
//		Car car2 = context.getBean(Car.class);
//		System.out.println(car1);
//		System.out.println(car2);
		Vehicle vehicle = context.getBean("car",Vehicle.class);
		vehicle.run();
	}

}
