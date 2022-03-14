package com.andreibu.examples;

import com.andreibu.base.StreamsBase;
import com.andreibu.models.SomeModel;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsFilterExamples extends StreamsBase {
    @Override
    public void run() {
        initialize();

        /**
         * Filter is an intermediate operation that allows us to filter the stream
         */
        // Filtering using explicit predicate declaration and composition
        List<SomeModel> filteredModels = this.someModelCollection.stream().filter((new Predicate<SomeModel>() {
            @Override
            public boolean test(SomeModel someModel) {
                return someModel.getFloatValue() == 10.0f;
            }
        }).or(new Predicate<SomeModel>() {
            @Override
            public boolean test(SomeModel someModel) {
                return someModel.getFloatValue() == 11.0f;
            }
        })).collect(Collectors.toList());

        println(filteredModels, "Printing models with floats 10 and 11");

        // Same thing as above, but with the Java 8 simplified version
        filteredModels = this.someModelCollection.stream().filter(
                e -> e.getFloatValue() == 10.0f || e.getFloatValue() == 11.0f).collect(Collectors.toList());

        println(filteredModels, "Printing models with floats 10 and 11 TAKE 2");

        // Using method reference defined in SomeModel
        filteredModels = this.someModelCollection.stream().filter(SomeModel::isFloatBiggerThan10).collect(Collectors.toList());

        println(filteredModels, "Printing models with floats bigger than 10");
    }
}
