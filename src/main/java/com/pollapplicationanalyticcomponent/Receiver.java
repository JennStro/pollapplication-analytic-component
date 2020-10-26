package com.pollapplicationanalyticcomponent;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @Autowired PollRepository pollRepository;

    @RabbitListener(queues = PollapplicationAnalyticComponentApplication.queueName)
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }
}
