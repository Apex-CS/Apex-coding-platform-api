package com.apex.coder.util;

import com.apex.coder.dto.CodeCases;
import com.apex.coder.dto.CodeResults;
import com.apex.coder.dto.response.CodeRunResponse;
import com.apex.coder.service.CodeService;
import lombok.extern.slf4j.Slf4j;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.apex.coder.Constants.FAIL;
import static com.apex.coder.Constants.PASS;
import static com.apex.coder.dto.CodeResults.FAILED;
import static com.apex.coder.dto.CodeResults.SUCCESS;

@Slf4j
public class JavaCore {


    static private PrintStream oldOut = System.out;
    static private InputStream oldIn = System.in;

    public static String compiler(final String codeString, final String className, final String path) {
        String result = "";
        try {
            Path temp = Paths.get(System.getProperty("java.io.tmpdir"), path);
            Files.createDirectories(temp);
            Path javaSourceFile = Paths.get(temp.normalize().toAbsolutePath().toString(), className + ".java");
            log.info("The java source file is located at " + javaSourceFile);

            Files.write(javaSourceFile, codeString.getBytes());
            File[] files1 = {javaSourceFile.toFile()};
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager =
                    compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> compilationUnits =
                    fileManager.getJavaFileObjectsFromFiles(Arrays.asList(files1));
            DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
            JavaCompiler.CompilationTask task = compiler.getTask(
                    null,
                    fileManager,
                    diagnostics,
                    null,
                    null,
                    compilationUnits
            );
            task.call();
            var errors = new StringBuilder();
            for (Diagnostic diagnostic : diagnostics.getDiagnostics()){
                if(diagnostic.getLineNumber() != -1){
                    errors.append(
                            String.format(
                                    "Error on line %s, %s%n",
                                    diagnostic.getLineNumber(),
                                    diagnostic.getMessage(Locale.ENGLISH)
                            )
                    );
                }

            }
            fileManager.close();
            result = errors.toString();

        } catch (Exception e){
            log.error(e.getMessage());
        }
        return result;
    }

    public static String getRunOutput(final String className, final String path, final String input) {
        Method method = getClassMethod(className, path);
        try {
            var baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            method.invoke(null, new Object[]{ new String[]{""} });
            return baos.toString();
        } catch (Exception e){
            log.error(e.getMessage());
        } finally {
            clearSystem();
        }
        return "";
    }


    public static String getRunMultipleOutput(final String className, final String path, final List<CodeCases> codeCases) {
        Method method = getClassMethod(className, path);
        StringBuilder response = new StringBuilder();
        codeCases.forEach(codeCase -> {
            var baos = new ByteArrayOutputStream();
            System.setOut(new PrintStream(baos));
            System.setIn(new ByteArrayInputStream(codeCase.getInput_values().getBytes()));
            try {
                var init = System.currentTimeMillis();
                method.invoke(null, new Object[]{ new String[]{""} });
                var output = baos.toString();
                response.append( output.equals(codeCase.getExpected_values())? PASS: FAIL )
                        .append("\tCase: ").append(codeCase.getInput_values())
                        //.append("\tResult: ").append(output)
                        //.append("\tExpected: ").append(codeCase.getExpected_values())
                        .append("\t")
                        .append(System.currentTimeMillis() - init)
                        .append(" ms\n");
            } catch (InvocationTargetException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
            System.out.flush();

        });
        clearSystem();
        return response.toString();
    }

    public static Method getClassMethod(final String className, final String path) {
        var temp = Paths.get(System.getProperty("java.io.tmpdir"), path);
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(
                    new URL[] { temp.toUri().toURL() },
                    CodeService.class.getClassLoader()
            );
            return urlClassLoader.loadClass(className).getMethod("main", String[].class);
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }
    private static void clearSystem(){
        System.setOut(oldOut);
        System.setIn(oldIn);
    }
}
