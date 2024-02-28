package com.apex.coder.util;

import com.apex.coder.service.CodeService;
import lombok.extern.slf4j.Slf4j;

import javax.tools.*;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

@Slf4j
public class JavaCore {

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

    public static String getRunOutput(final String className, final String input, final String path) {
        Path temp = Paths.get(System.getProperty("java.io.tmpdir"), path);
        String result = "";
        try {
            URLClassLoader urlClassLoader = new URLClassLoader(
                    new URL[] { temp.toUri().toURL() },
                    CodeService.class.getClassLoader()
            );
            Method method = urlClassLoader.loadClass(className).getMethod("main", String[].class);
            var args = new Object[]{
                    new String[]{""}
            };
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream old = System.out;
            System.setOut(new PrintStream(baos));
            method.invoke(null, args);
            System.out.flush();
            System.setOut(old);
            result = baos.toString();
        } catch (Exception e){
            log.error(e.getMessage());
        }
        return result;
    }
}
