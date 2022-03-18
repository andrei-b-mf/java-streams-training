package com.andreibu.solutions;

import com.andreibu.exercises.StreamsForEachExercises;

import java.util.HashSet;
import java.util.Set;

public class StreamsForEachSolutions extends StreamsForEachExercises {
    @Override
    protected void printSomeModelCollectionSequentiallyWithThreadIdAndPrintTheNumberOfDifferentThreadsUsed() {
        Set<Long> s = new HashSet<>();
        someModelCollection.stream().forEach(e -> {
            long currentThreadId = Thread.currentThread().getId();
            System.out.println("ThreadId: " + currentThreadId);
            System.out.println(e.toString());
            s.add(currentThreadId);
        });

        System.out.println("Threads used: " + s.size());
    }

    @Override
    protected void printSomeModelCollectionInParallelWithThreadIdAndPrintTheNumberOfDifferentThreadsUsed() {
        Set<Long> s = new HashSet<>();
        someModelCollection.parallelStream().forEach(e -> {
            System.out.println("ThreadId: " + Thread.currentThread().getId());
            System.out.println(e.toString());
            s.add(Thread.currentThread().getId());
        });

        System.out.println("Threads used: " + s.size());
    }

    @Override
    protected void printSomeModelCollectionInParallelWithThreadIdAndPrintTheNumberOfDifferentThreadsUsedOptimized() {
        Set<Long> s = new HashSet<>();
        someModelCollection.parallelStream().forEach(e -> {
            long currentThreadId = Thread.currentThread().getId();
            String eToString = e.toString();
            System.out.println("ThreadId: " + currentThreadId);
            System.out.println(eToString);
            s.add(currentThreadId);
        });

        System.out.println("Threads used: " + s.size());
    }
}