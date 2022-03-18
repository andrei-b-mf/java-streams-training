package com.andreibu.solutions;

import com.andreibu.exercises.StreamsFlatMapExercises;
import com.andreibu.models.Wheel;
import com.andreibu.models.WheelMounting;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsFlatMapSolutions extends StreamsFlatMapExercises {
    @Override
    protected void printAllCars() {
        println(cars);
    }

    @Override
    protected void printAllWheelsOfAllCars() {
        List<Wheel> wheels = cars.stream().flatMap(c -> c.getWheels().stream()).collect(Collectors.toList());
        println(wheels);
    }

    @Override
    protected void printRearWheelsOfAllCars() {
        List<Wheel> wheels = cars.stream().flatMap(c -> c.getWheels(Set.of(WheelMounting.REAR_LEFT, WheelMounting.READ_RIGHT)).stream()).collect(Collectors.toList());
        println(wheels);
    }

    @Override
    protected void printWheelsWithRimBiggerThan15Inch() {
        List<Wheel> wheels = cars.stream().flatMap(c -> c.getWheels().stream()).filter(w -> w.rimDiameter > 15).collect(Collectors.toList());
        println(wheels);
    }

    @Override
    protected void printWheelsWithAspectRatioEqualTo50AndRimEqualsTo14Inch() {
        List<Wheel> wheels = cars.stream().flatMap(c -> c.getWheels().stream()).filter(w -> w.aspectRatio == 50 && w.rimDiameter == 14).collect(Collectors.toList());
        println(wheels);
    }
}
