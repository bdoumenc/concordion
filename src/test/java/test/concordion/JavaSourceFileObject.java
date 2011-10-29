package test.concordion;

import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class JavaSourceFileObject extends SimpleJavaFileObject {
    final String sourceCode;

    /**
     * Constructs a new JavaSourceFileObject.
     * 
     * @param className the fully qualified name of the Java class
     * @param sourceCode the Java source sourceCode
     */
    JavaSourceFileObject(String className, String sourceCode) {
        super(URI.create("string:///" + className.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
        this.sourceCode = sourceCode;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return sourceCode;
    }
}