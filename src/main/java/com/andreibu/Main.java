package com.andreibu;

import com.andreibu.examples.StreamsFilterExamples;
import com.andreibu.examples.StreamsFlatMapExamples;
import com.andreibu.examples.StreamsForEachExamples;
import com.andreibu.examples.StreamsMapExamples;

public class Main {
    public static void main(String[] args) {
        System.out.println("Running streams foreach examples");
        StreamsForEachExamples streamsForEachExamples = new StreamsForEachExamples();
        streamsForEachExamples.run();

        System.out.println("Running streams filtering examples");
        StreamsFilterExamples streamsFilterExamples = new StreamsFilterExamples();
        streamsFilterExamples.run();

        System.out.println("Running streams map examples");
        StreamsMapExamples streamsMapExamples = new StreamsMapExamples();
        streamsMapExamples.run();

        System.out.println("Running streams flatMap examples");
        StreamsFlatMapExamples streamsFlatMapExamples = new StreamsFlatMapExamples();
        streamsFlatMapExamples.run();
    }
}