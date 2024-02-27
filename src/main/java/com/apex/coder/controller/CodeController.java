package com.apex.coder.controller;

import com.apex.coder.dto.CodeResults;
import com.apex.coder.dto.request.CodeRunRequest;
import com.apex.coder.dto.response.CodeRunResponse;
import com.apex.coder.service.CodeService;
import org.python.util.PythonInterpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1")
public class CodeController {
    @Autowired
    private CodeService codeService;
    @PostMapping(value = "/javaCode")
    public @ResponseBody CodeRunResponse runJavaCases(@RequestBody final CodeRunRequest request){
        return codeService.runJavaCode(request);
    }

    @PostMapping(value = "/pythonCode")
    public @ResponseBody CodeRunResponse runPythonCases(@RequestBody final CodeRunRequest request){
        return codeService.runPythonCode(request);
    }

}
