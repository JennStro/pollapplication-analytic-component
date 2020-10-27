package com.pollapplicationanalyticcomponent;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;

@Document(collection = "FinishedPolls")
public class Poll {

    @Id
    private Long id;

    private String question;

    private int yes;
    private int no;

    private Instant received;

    public Poll() {};

    public Poll setId(Long id) {
        this.id = id;
        return this;
    }

    public Poll setQuestion(String question) {
        this.question = question;
        return this;
    }

    public Poll setYes(int yes) {
        this.yes = yes;
        return this;
    }

    public Poll setNo(int no) {
        this.no = no;
        return this;
    }

    public Poll setReceived(Instant received) {
        this.received = received;
        return this;
    }
}
