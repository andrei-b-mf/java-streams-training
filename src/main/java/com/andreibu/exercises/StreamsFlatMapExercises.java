package com.andreibu.exercises;

import com.andreibu.base.StreamsBase;

public class StreamsFlatMapExercises extends StreamsBase {

    public StreamsFlatMapExercises() {
        super(false, true);
    }

    @Override
    protected void runInternal() {
        println("printAllCarsForInfoPurposes");
        printAllCars();
        println("printAllWheelsOfAllCars");
        printAllWheelsOfAllCars();
        println("printRearWheelsOfAllCars");
        printRearWheelsOfAllCars();
        println("printWheelsWithRimBiggerThan15Inch");
        printWheelsWithRimBiggerThan15Inch();
        println("printWheelsWithAspectRatioEqualTo50AndRimEqualsTo14Inch");
        printWheelsWithAspectRatioEqualTo50AndRimEqualsTo14Inch();
    }

    protected void printAllCars() {
        // TODO Implement
    }

    protected void printAllWheelsOfAllCars() {
        // TODO Implement
    }

    protected void printRearWheelsOfAllCars() {
        // TODO Implement
    }

    protected void printWheelsWithRimBiggerThan15Inch() {
        // TODO Implement
    }

    protected void printWheelsWithAspectRatioEqualTo50AndRimEqualsTo14Inch() {
        // TODO Implement
    }
}
