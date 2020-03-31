package com.dummyProject;
import sun.management.MethodInfo;
import java.lang.reflect.Method;
import java.lang.annotation.Annotation;

public class AnnotationExample {
    @Override
    @MethodInfo(author = "Kirti", comments = "Main method", date = "March 30 2020", revision = 1)
    public String toString() {
        return "Overridden toString method";
    }

    @Deprecated
    @MethodInfo(comments = "deprecated method", date = "March 30 2020")
    public static void oldMethod() {
        System.out.println("old method, don't use it.");
    }

    public static void main(String[] args) {
        try {
            for (Method method : AnnotationExample.class.getMethods()) {
                // checks if MethodInfo annotation is present for the method
                if (Method.isAnnotationPresent(MethodInfo.class)) {
                    try {
                        // iterates all annotation available in the method
                        for (Annotation annotation : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method" + method + ":" + annotation);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }
}