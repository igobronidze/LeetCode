package com.codeforces;

import com.codeforces.round600.ProblemC;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class ProblemTest {

    protected static Map<String, String> cases  = new HashMap<>();

    protected void testCases(Class clazz) {
        for (Map.Entry<String, String> entry : cases.entrySet()) {
            testCase(clazz, entry.getKey(), entry.getValue());
        }
    }

    private void testCase(Class clazz, String input, String expectedOutput) {
        setInputStream(clazz, input);
        ByteArrayOutputStream byteArrayOutputStream = createAndSetOutputStream(clazz);
        executeMainMethod(clazz);

        Assert.assertEquals(expectedOutput, new String(byteArrayOutputStream.toByteArray()));
    }

    private void setInputStream(Class clazz, String input) {
        try {
            Field inputStreamField = clazz.getField("inputStream");
            inputStreamField.set(null, new ByteArrayInputStream(input.getBytes()));
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
    }

    private ByteArrayOutputStream createAndSetOutputStream(Class clazz) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            Field outputStreamField = clazz.getField("outputStream");
            outputStreamField.set(null, byteArrayOutputStream);
        } catch (NoSuchFieldException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return byteArrayOutputStream;
    }

    private void executeMainMethod(Class clazz) {
        try {
            String[] params = null;
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, (Object) params);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException ex) {
            ex.printStackTrace();
        }
    }
}
