package com.apex.coder.controller;

import com.apex.coder.dto.request.CodeRunRequest;
import com.apex.coder.dto.request.ProblemRequest;
import com.apex.coder.dto.response.CodeRunResponse;
import com.apex.coder.dto.response.ProblemResponse;
import com.apex.coder.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(path="api/v1")
public class CodeController {
    @Autowired
    private CodeService codeService;
    @PostMapping(value = "/java_code")
    public @ResponseBody CodeRunResponse runJavaCode(@RequestBody final CodeRunRequest request){
        return codeService.runJavaCode(request);
    }

    @PostMapping(value = "/java_test_cases")
    public @ResponseBody CodeRunResponse runJavaTestCases(@RequestBody final CodeRunRequest request){
        return codeService.runJavaTestCases(request);
    }

    @PostMapping(value = "/load_case")
    public @ResponseBody ProblemResponse getProblem(@RequestBody final ProblemRequest request){
        return codeService.getProblem(request);
    }

    @PostMapping(value = "/python_code")
    public @ResponseBody CodeRunResponse runPythonCode(@RequestBody final CodeRunRequest request){
        return codeService.runPythonCode(request);
    }

}
