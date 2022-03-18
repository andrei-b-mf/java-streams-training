package com.andreibu.base;

import com.andreibu.models.Car;
import com.andreibu.models.SomeModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

public abstract class StreamsBase implements Runnable {
    protected Collection<SomeModel> someModelCollection;
    protected Collection<Car> cars;

    protected void initialize() {
        someModelCollection = new ArrayList<>();
        cars = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            SomeModel m = new SomeModel(i % 2, String.valueOf(i), Float.valueOf(i));
            someModelCollection.add(m);
            int randomFactor = ThreadLocalRandom.current().nextInt(0, 3);
            Car c = new Car(205, 50 + 5 * randomFactor, 14 + 2 * randomFactor);
            cars.add(c);
        }


        // I must implement:
        // someModelCollection.stream().forEach();
        // someModelCollection.stream().filter();
        // someModelCollection.stream().map();
        // someModelCollection.stream().flatMap();
        // someModelCollection.stream().allMatch();
        // someModelCollection.stream().anyMatch();
        // someModelCollection.stream().peek();
        // someModelCollection.stream().flatMapToDouble(someModel -> DoubleStream.of(((Float)someModel.getaFloat()).doubleValue()));
        // someModelCollection.stream().findAny();
        // someModelCollection.stream().findFirst();
        // someModelCollection.stream().distinct()
        // someModelCollection.stream().skip();
        // someModelCollection.stream().max();
        // someModelCollection.stream().noneMatch();
        // someModelCollection.stream().limit();
        // someModelCollection.stream().reduce();
    }

    public static <T> void println(Collection<T> collection) {
        collection.forEach(e -> println(e.toString()));
    }

    public static <T> void println(Map<? extends Object, ? extends Object> map) {
        map.entrySet().forEach(e -> {
            System.out.println("key: " + e.getKey().toString() + "; value: " + e.getValue().toString());
        });
    }

    public static <T> void print(Collection<T> collection) {
        collection.forEach(e -> print(e.toString(), " "));
        System.out.println();
    }

    public static <T> void print(T[] array) {
        for(int i = 0; i < array.length; i++) {
            print(String.valueOf(array[i]), " ");
        }

        System.out.println();
    }

    public static void print(int[] array) {
        for(int i = 0; i < array.length; i++) {
            print(String.valueOf(array[i]), " ");
        }

        System.out.println();
    }

    public static void print(long[] array) {
        for(int i = 0; i < array.length; i++) {
            print(String.valueOf(array[i]), " ");
        }

        System.out.println();
    }

    public static void print(double[] array) {
        for(int i = 0; i < array.length; i++) {
            print(String.valueOf(array[i]), " ");
        }

        System.out.println();
    }

    public static <T> void println(Collection<T> collection, String message) {
        if(message != null) {
            System.out.println(message);
        }

        println(collection);
    }

    public static <T> void print(Collection<T> collection, String message) {
        if(message != null) {
            System.out.println(message);
        }

        print(collection);
    }

    public static <T> void print(T[] array, String message) {
        if(message != null) {
            System.out.println(message);
        }

        print(array);
    }

    public static void print(int[] array, String message) {
        if(message != null) {
            System.out.println(message);
        }

        print(array);
    }

    public static void print(long[] array, String message) {
        if(message != null) {
            System.out.println(message);
        }

        print(array);
    }

    public static void print(double[] array, String message) {
        if(message != null) {
            System.out.println(message);
        }

        print(array);
    }

    public void throwSomething() throws Exception {

    }

    public static void print(String message, String suffix) {
        System.out.print(message + suffix);
    }

    public static void println(String message) {
        System.out.println(message);
    }
}
