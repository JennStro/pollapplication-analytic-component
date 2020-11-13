package com.pollapplicationanalyticcomponent;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class Receiver {

  @Autowired PollRepository pollRepository;

  @RabbitListener(queues = PollapplicationAnalyticComponentApplication.queueName)
  public void receiveMessage(String message) {
    System.out.println("Received " + message);
    if (message.equals("started queue")) {
      System.out.println("Server has started queue.");
    } else {
      ObjectMapper mapper = new ObjectMapper();
      try {
        JsonNode pollObject = mapper.readTree(message);
        JsonNode votesObject = mapper.readTree(String.valueOf(pollObject.get("votes")));
        pollRepository.save(
                new Poll()
                        .setId(pollObject.get("id").longValue())
                        .setQuestion(pollObject.get("question").textValue())
                        .setYes(votesObject.get("yes").intValue())
                        .setNo(votesObject.get("no").intValue())
                        .setReceived(Instant.now()));
      } catch (JsonProcessingException e) {
        e.printStackTrace();
      }
    }
  }
}
