package com.pollapplicationanalyticcomponent;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = PollapplicationAnalyticComponentApplication.queueName)
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
