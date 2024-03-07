package com.apex.coder.repository;

import com.apex.coder.entities.CodeChallenge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeChallengeRepository extends CrudRepository<CodeChallenge, Integer> {
}
