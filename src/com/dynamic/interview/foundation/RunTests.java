package com.dynamic.interview.foundation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author: xinghj0308@gmail.com
 * @create: 2021/12/20
 * @description:
 */
public class RunTests {
    public static void main(String[] args) throws Exception {
        int test = 0;
        int passed = 0;
        Class<?> testClass = Class.forName(args[0]);
        for (Method m : testClass.getDeclaredMethods()) {
            if (m.isAnnotationPresent(Test.class)) {
                test++;
                try {
                    m.invoke(null);
                    passed++;
                } catch (InvocationTargetException wrappedExc) {
                    Throwable exc = wrappedExc.getCause();
                    System.out.println(m + " failed: " + exc);
                } catch (Exception ec) {
                    System.out.println("Invaild @Test:" + m);
                }
            }
        }
        System.out.printf("Passed: %d, Failed: %d%n", passed, test - passed);
    }
}
