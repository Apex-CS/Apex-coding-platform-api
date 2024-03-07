package com.apex.coder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class CodeTestCase {
    @ManyToOne
    @JoinColumn(name="code_challenge_id", nullable=false)
    private CodeChallenge codeChallenge;
    @Id
    private int id;
    private int maxDuration;
    private String input;
    private String output;

}
