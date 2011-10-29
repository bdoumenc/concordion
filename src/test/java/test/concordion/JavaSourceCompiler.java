package test.concordion;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Arrays;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

public class JavaSourceCompiler {

    private static final String TARGET_DIR = "target/genClasses";
    private static final String CLASS_PATH = System.getProperty("java.class.path") + ":" + TARGET_DIR;

    public Class<?> compile(String className, String sourceCode) throws Exception {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        
        StandardJavaFileManager fileManager;
        try {
            fileManager = compiler.getStandardFileManager(null, null, null);
            new File(TARGET_DIR).mkdirs();
        } catch (NullPointerException e) {
            throw new IllegalStateException("Test requires the system Java compiler. " +
            		"Check that your classpath contains tools.jar, or run the tests using a Java Development Kit (JDK), rather than a Java Runtime Environment (JRE). " +
            		"The Java version must be 1.6.0 or later.");
        }
        
        try {
            JavaSourceFileObject source = new JavaSourceFileObject(className, sourceCode);
            Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(new JavaSourceFileObject[] { source });
    
            Iterable<String> options = Arrays.asList(new String[] { "-classpath", CLASS_PATH, "-d", TARGET_DIR});
            Boolean compiledOK = compiler.getTask(null, fileManager, null, options, null, compilationUnits).call();
            if (!compiledOK) {
                throw new RuntimeException("Compilation failure");
            }
    
            ClassLoader urlClassLoader = new URLClassLoader(new URL[] { new File(TARGET_DIR).toURI().toURL() });
            Class<?> compiledClass = urlClassLoader.loadClass(className);
    
            return compiledClass;

        } finally {
            try {
                fileManager.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
