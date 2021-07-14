package com.ims.owen.javathecode;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static net.bytebuddy.matcher.ElementMatchers.named;

@SpringBootApplication
public class JavaTheCodeApplication {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        Class<?> bookClass = Class.forName("com.ims.owen.javathecode.Book");
//        Class<Book> bookClass = Book.class;
        Constructor<?> constructors = bookClass.getConstructor(String.class);
        Book book = null;
        try {
            book = (Book) constructors.newInstance("MyBook");
            System.out.println(book);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Annotation[] declaredAnnotations = bookClass.getDeclaredAnnotations();
        Arrays.stream(declaredAnnotations).forEach(annotation -> System.out.println(annotation));
        try {
            Field a = Book.class.getDeclaredField("A");
            System.out.println(a.get(null));
            a.set(null, "AAAAA");
            System.out.println(a.get(null));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Field b = Book.class.getDeclaredField("B");
            b.setAccessible(true);
            System.out.println(b.get(book));
            b.set(book, "BBBB");
            System.out.println(b.get(book));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        try {

            c.invoke(book);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        try {
            int invoke = (int) sum.invoke(book, 1, 2);
            System.out.println(invoke);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
