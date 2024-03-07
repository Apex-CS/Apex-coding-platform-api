package com.apex.coder.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;

import java.util.Set;

@Entity
@Getter
public class CodeChallenge {
    @Id
    private int id;
    private String code;
    private String level;
    private String description;
    private String input;
    private String output;
    @OneToMany(mappedBy="codeChallenge")
    private Set<CodeTestCase> testCases;

}
