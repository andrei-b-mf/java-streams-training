package com.andreibu.examples;

import com.andreibu.base.StreamsBase;
import com.andreibu.models.Wheel;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsFlatMapExamples extends StreamsBase {
    @Override
    protected void runInternal() {
        // flatMap is used to map a single element from a source stream to multiple elements from a new stream and afterwards
        // merging all the elements into a common type stream
        println("Simple example of getting wheels from all cars");
        List<Wheel> wheelsOfAllOurCars = cars.stream().flatMap(c -> c.getWheels().stream()).collect(Collectors.toList());
        println(wheelsOfAllOurCars);

        println("Printing all wheels which are bigger than 16 inch, retrieved from all cars");
        List<Wheel> wheelsBiggerThan16inch = cars.stream().flatMap(c -> c.getWheels().stream().filter(w -> w.rimDiameter > 16)).collect(Collectors.toList());
        println(wheelsBiggerThan16inch);
    }
}
