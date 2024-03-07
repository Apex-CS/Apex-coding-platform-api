package com.apex.coder.service;

import com.apex.coder.Constants;
import com.apex.coder.dto.CodeCases;
import com.apex.coder.dto.CodeResults;
import com.apex.coder.dto.request.CodeRunRequest;
import com.apex.coder.dto.request.ProblemRequest;
import com.apex.coder.dto.response.CodeRunResponse;
import com.apex.coder.dto.response.ProblemResponse;
import com.apex.coder.entities.CodeChallenge;
import com.apex.coder.repository.CodeChallengeRepository;
import com.apex.coder.util.JavaCore;
import lombok.extern.slf4j.Slf4j;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import static com.apex.coder.Constants.MAIN;

@Service
@Slf4j
public class CodeService {

    @Autowired
    CodeChallengeRepository codeChallengeRepository;

    public CodeRunResponse runJavaCode(final CodeRunRequest request){
        var codeString = new String(Base64.getDecoder().decode(request.getCode()));
        log.info(codeString);
        var compiler = JavaCore.compiler(codeString, MAIN, request.getSession_id());
        if(!compiler.isEmpty()){
            return new CodeRunResponse(LocalDateTime.now(), 0, CodeResults.FAILED, compiler);
        }
        var input = new String(Base64.getDecoder().decode(request.getInput_values()));
        log.info(input);
        var init = System.currentTimeMillis();
        var result = JavaCore.getRunOutput(MAIN, request.getSession_id(), input);
        log.info("result "+ result);
        return new CodeRunResponse(
                LocalDateTime.now(),
                System.currentTimeMillis() - init,
                CodeResults.SUCCESS,
                result
        );

    }

    public CodeRunResponse runJavaTestCases(final CodeRunRequest request){
        Optional<CodeChallenge> testCases = codeChallengeRepository.findById((int) request.getCase_id());
        List<CodeCases> cases = new ArrayList<>();
        testCases.ifPresent(codeChallenge -> codeChallenge.getTestCases()
                .forEach(item -> cases.add(new CodeCases(item.getInput(), item.getOutput()))));
        log.info("cases "+ cases.size());
        var init = System.currentTimeMillis();
        var output = JavaCore.getRunMultipleOutput(MAIN, request.getSession_id(), cases);
        log.info("result "+ output);
        return new CodeRunResponse(
                LocalDateTime.now(),
                System.currentTimeMillis() - init,
                output.contains(Constants.PASS)?
                        !output.contains(Constants.FAIL)? CodeResults.SUCCESS: CodeResults.PARTIAL
                        :CodeResults.FAILED,
                output
        );

    }

    public CodeRunResponse runPythonCode(final CodeRunRequest request){
        var codeString = new String(
                Base64.getDecoder().decode(request.getCode())
        );
        log.info(codeString);
        StringWriter out = new StringWriter();
        var init = System.currentTimeMillis();
        try {
            PythonInterpreter pyInt = new PythonInterpreter();
            pyInt.setOut(out);
            pyInt.setErr(out);
            pyInt.exec(codeString);
        } catch (Exception e){
            return new CodeRunResponse(
                    LocalDateTime.now(),
                    System.currentTimeMillis(),
                    CodeResults.FAILED,
                    e.getMessage()
            );
        }
        return new CodeRunResponse(
                LocalDateTime.now(),
                System.currentTimeMillis() - init,
                CodeResults.SUCCESS,
                out.toString()
        );

    }

    public ProblemResponse getProblem(final ProblemRequest request){
        Optional<CodeChallenge> testCases = codeChallengeRepository.findById((int) request.getCase_id());
        return testCases.map(codeChallenge -> new ProblemResponse(
                codeChallenge.getDescription(),
                codeChallenge.getCode(),
                codeChallenge.getInput()
                )
        ).orElse(new ProblemResponse());
    }
}
