package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class NotificationSystemSpringApplication {

    public static void main(String[] args) {

        ConfigurableApplicationContext context =
                SpringApplication.run(NotificationSystemSpringApplication.class, args);

        System.out.println("---- Container Started ----");

        Notification email = (Notification) context.getBean("emailBean");
        email.send("Hello via Email");

        System.out.println("-------------------------");

        Notification sms = (Notification) context.getBean("smsBean");
        sms.send("Hello via SMS");

        context.close();
    }
}
