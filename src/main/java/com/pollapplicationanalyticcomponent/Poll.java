package com.pollapplicationanalyticcomponent;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

@Document(collection = "FinishedPolls")
public class Poll {

    @Id
    private Long id;

    private String question;

    public Poll() {};

    public Poll(Long id, String question) {
        this.id = id;
        this.question = question;
    }
}
