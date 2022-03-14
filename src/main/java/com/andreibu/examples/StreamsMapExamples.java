package com.andreibu.examples;

import com.andreibu.base.StreamsBase;
import com.andreibu.models.SomeModel;
import com.andreibu.models.StringModel;

import java.util.*;
import java.util.stream.Collectors;

public class StreamsMapExamples extends StreamsBase {
    @Override
    public void run() {
        initialize();

        /**
         * Map is used for the transforming a collection of some Objects into a collection of different Objects
         * The word Map might be confusing at the beginning because it actually allows you to transform and it is not
         * a mapping of sort you can later use as Map<T>
         * There is a very nice talk on this topic (so fortunate we are doing this in 2020):
         * https://dev.to/techgirl1908/why-is-map-called-map-2l03. So based on this thread, we can conclude that the naming
         * comes from Mathematical Set Theory map function which is a function that related all points from one set to another
         */
        executeMapOnPrimitivesExamples();
        executeMapOnObjectsExamples();
    }

    private void executeMapOnPrimitivesExamples() {
        /**
         * In Java, we have primitive types, like: byte, short, int, long, float, double, boolean, char.
         * Additionally, while String is not technically primitive, it might be considered so because of the special support
         * it receives from the language. https://docs.oracle.com/javase/tutorial/java/nutsandbolts/datatypes.html
         *
         * Related to streams, in order to allow working with primitive types and avoid boxing and unboxing issues,
         * special stream implementations are created: IntStream, DoubleStream, LongStream
         * Why only int, double and long? Because these made the most sense.
         * https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
         */
        int[] intPrimitiveArray = someModelCollection.stream().mapToInt(SomeModel::getIntValue).toArray();
        print(intPrimitiveArray, "All int values from the models as primitive array 1");

        // Same thing using lambda, not method reference
        intPrimitiveArray = someModelCollection.stream().mapToInt(e -> e.getIntValue()).toArray();
        print(intPrimitiveArray, "All int values from the models as primitive array 2");

        // Transforming IntStream to Stream<Integer>
        List<Integer> integerList = someModelCollection.stream().mapToInt(e -> e.getIntValue()).boxed().collect(Collectors.toList());
        print(integerList, "All int values from the models as list");

        // Getting float values from SomeMode and printing them
        double[] floatsAsDoubles = someModelCollection.stream().mapToDouble(e -> e.getFloatValue()).toArray();
        print(floatsAsDoubles, "All float values from the models as primitive double array");

        // Getting int values as longs and printing them
        long[] integersAsLongs = someModelCollection.stream().mapToLong(e -> e.getIntValue()).toArray();
        print(integersAsLongs, "All integer values from the models as primitive long array");

        // Starting from a Collection of SomeModel, mapping to LongStream and then mapping into a new SomeModel
        List<SomeModel> someModelList = someModelCollection.stream().mapToLong(e -> e.getIntValue())
                .mapToObj(e -> new SomeModel((int) e, "", 0.0f)).collect(Collectors.toList());
        println(someModelList, "All integer values from the models as primitive long array then converting to map of SomeModel");
    }

    private void executeMapOnObjectsExamples() {
        // Decorating model's toString representation with a prefix
        List<String> objectsAsStrings = someModelCollection.stream().map(e -> "Decorated model: " + e.toString()).collect(
                Collectors.toList());
        println(objectsAsStrings, "Our models printed as strings");

        List<SomeModel> someModels = someModelCollection.stream().map(
                e -> new SomeModel(e.getIntValue(), e.getStringValue(), 0.0f)).collect(Collectors.toList());
        println(someModels, "SomeModels with float 0.0f values");

        printUnorderedMap();

        printOrderedMap();

        println("Printing models collected into a stack");
        Stack<StringModel> stackedModels = someModelCollection.stream().map(e -> new StringModel(e.getId(), e.getStringValue()))
                .collect(Collectors.toCollection(Stack::new));
        while(!stackedModels.empty()) {
            print("Model in stack: ", stackedModels.pop().toString());
            println("");
        }
    }

    private void printOrderedMap() {
        println("Ordered map");
        // Creating a map that allows us to access the models based on their ID directly, but preserving ascending order
        Map<String, SomeModel> someModelsMappedByIdOrdered = someModelCollection.stream().map(
                e -> new LinkedHashMap.SimpleEntry<>(e.getId(), e))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),
                        (k, v) -> {
                            throw new IllegalStateException(String.format("Duplicate key %s", k));
                        },
                        LinkedHashMap::new));
        someModelsMappedByIdOrdered.entrySet().stream().forEach(e -> {
            print("Model with ID: " + e.getKey() + ". ", e.getValue().toString());
            println("");
        });
    }

    private void printUnorderedMap() {
        println("Unordered map");
        // Creating a map that allows us to access the models based on their ID directly
        Map<String, SomeModel> someModelsMappedById = someModelCollection.stream().map(
                e -> new HashMap.SimpleEntry<>(e.getId(), e))
                .collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
        someModelsMappedById.entrySet().stream().forEach(e -> {
            print("Model with ID: " + e.getKey() + ". ", e.getValue().toString());
            println("");
        });
    }
}
