package org.concordion.internal.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;

import android.content.Context;

public class IOUtil {
    
    private static final int BUFFER_SIZE = 4096;
    
    public static void copy(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[BUFFER_SIZE];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, len);
        }
    }

    public static String readResourceAsString(Context context, String filename) {
        InputStream resourceStream = null;
        try {
            resourceStream = context.getAssets().open(filename);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return readResourceAsString(resourceStream, "UTF-8");
    }

    public static String readResourceAsString(String resourcePath) {
        return readResourceAsString(resourcePath, "UTF-8");
    }

    public static String readResourceAsString(String resourcePath, String charsetName) {
        InputStream resourceStream = getResourceAsStream(resourcePath);
        return readResourceAsString(resourceStream, charsetName);
    }

    public static String readResourceAsString(InputStream resource, String charsetName) {
        try {
            if (resource == null) {
                throw new IOException("Resource not found");
            }
            Reader reader = new InputStreamReader(resource, charsetName);
            try {
                return readAsString(reader);
            } finally {
                reader.close();
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read resource", e);
        }
    }
    
    public static String readAsString(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader bufferedReader = new BufferedReader(reader);
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        return sb.toString();
    }

    public static InputStream getResourceAsStream(String resourcePath) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader.getResourceAsStream(resourcePath.replaceFirst("/", ""));
    }
}
