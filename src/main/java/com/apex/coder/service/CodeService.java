package com.apex.coder.service;

import com.apex.coder.dto.CodeResults;
import com.apex.coder.dto.request.CodeRunRequest;
import com.apex.coder.dto.response.CodeRunResponse;
import com.apex.coder.util.JavaCore;
import lombok.extern.slf4j.Slf4j;
import org.python.util.PythonInterpreter;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.util.Base64;

@Service
@Slf4j
public class CodeService {


    public CodeRunResponse runJavaCode(final CodeRunRequest request){
        var codeString = new String(Base64.getDecoder().decode(request.getCode()));
        log.info(codeString);
        var compiler = JavaCore.compiler(codeString, "Main", request.getSession_id());
        if(!compiler.isEmpty()){
            return new CodeRunResponse(LocalDateTime.now(), 0, CodeResults.FAILED, compiler);
        }
        var input = new String(Base64.getDecoder().decode(request.getInput_values()));
        log.info(input);
        var init = System.currentTimeMillis();
        var result = JavaCore.getRunOutput("Main", input, request.getSession_id());
        log.info("result "+ result);
        return new CodeRunResponse(
                LocalDateTime.now(),
                System.currentTimeMillis() - init,
                CodeResults.SUCCESS,
                result
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
}
