package com.andreibu.models;

import com.andreibu.util.IdGenerator;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Car {
    private final int id;
    private final Map<WheelMounting, Wheel> wheels;
    private boolean isInMotion;

    public Car(int wheelWidth, int wheelAspectRation, int rimDiameter) {
        id = IdGenerator.getNextId();
        wheels = new HashMap<>(4);
        wheels.put(WheelMounting.FRONT_LEFT, new Wheel(wheelWidth, wheelAspectRation, rimDiameter));
        wheels.put(WheelMounting.FRONT_RIGHT, new Wheel(wheelWidth, wheelAspectRation, rimDiameter));
        wheels.put(WheelMounting.REAR_LEFT, new Wheel(wheelWidth, wheelAspectRation, rimDiameter));
        wheels.put(WheelMounting.READ_RIGHT, new Wheel(wheelWidth, wheelAspectRation, rimDiameter));
    }

    @Override
    public String toString() {
        if (isCarReadyForDriving()) {
            return "Car not ready for driving! Mount the wheels first! Wheels mounted: " + wheels;
        }

        return "Car{" +
                "id=" + id +
                ", wheels=" + wheels +
                '}';
    }

    private boolean isCarReadyForDriving() {
        return wheels.size() != 4 || !(wheels.containsKey(WheelMounting.FRONT_LEFT) && wheels.containsKey(WheelMounting.FRONT_RIGHT)
                && wheels.containsKey(WheelMounting.REAR_LEFT) && wheels.containsKey(WheelMounting.FRONT_RIGHT));
    }

    public void unmountWheels() {
        wheels.clear();
    }

    public Wheel mountWheel(Wheel wheel, WheelMounting mounting) {
        return wheels.put(mounting, wheel);
    }

    public Collection<Wheel> getWheels() {
        return wheels.values();
    }

    public Collection<Wheel> getWheels(Set<WheelMounting> mountings) {
        return wheels.entrySet().stream().filter(e -> mountings.contains(e.getKey())).map(e -> e.getValue()).collect(Collectors.toList());
    }

    public void drive() {
        if (isCarReadyForDriving()) {
            isInMotion = true;
            System.out.println("Car is in motion!");
        } else {
            System.out.println("Car not ready for driving! Mount the wheels first! Wheels mounted: " + wheels);
        }
    }

    public void halt() {
        if (isInMotion) {
            System.out.println("Car halted!");
        } else {
            System.out.println("Car is not in motion");
        }
    }
}
