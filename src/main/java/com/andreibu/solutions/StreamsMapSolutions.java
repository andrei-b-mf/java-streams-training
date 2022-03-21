package com.andreibu.solutions;

import com.andreibu.exercises.StreamsMapExercises;
import com.andreibu.models.SomeModel;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsMapSolutions extends StreamsMapExercises {
    @Override
    protected void transformModelsIntoACollectionOfIntegersUsingIntValueAndPrintIt() {
        List<Integer> integers = someModelCollection.stream().map(m -> m.getIntValue()).collect(Collectors.toList());
        print(integers);
        integers = someModelCollection.stream().mapToInt(m -> m.getIntValue()).boxed().collect(Collectors.toList());
        print(integers);
    }

    @Override
    protected void transformModelsIntoACollectionOfDoublesUsingFloatValueAndPrintIt() {
        List<Double> doubles = someModelCollection.stream().mapToDouble(m -> m.getFloatValue()).boxed().collect(Collectors.toList());
        print(doubles);
    }

    @Override
    protected void transformModelsIntoAnArrayOfLongsUsingIntValueAndPrintIt() {
        long[] longs = someModelCollection.stream().mapToLong(m -> m.getIntValue()).toArray();
        print(longs);
    }

    @Override
    protected void buildNewSomeModelCollectionWithZeroIntegerValueAndPrintIt() {
        List<SomeModel> newSomeModelCollection = someModelCollection.stream().filter(m -> m.getIntValue() == 0)
                .map(m -> new SomeModel(m.getIntValue(), m.getStringValue(), m.getFloatValue())).collect(Collectors.toList());
        println(newSomeModelCollection);
    }

    @Override
    protected void buildNewStringModelCollectionUsingStringValueAddingAPrefixAndPrintIt() {
        List<SomeModel> newSomeModelCollection = someModelCollection.stream()
                .map(m -> new SomeModel(m.getIntValue(), "APrefix" + m.getStringValue(), m.getFloatValue())).collect(Collectors.toList());
        println(newSomeModelCollection);
    }

    @Override
    protected void buildNewSomeModelMapWhereKeyIsTheIDPlusString10AndPrintIt() {
        Map<String, SomeModel> newMap = someModelCollection.stream()
                .map(m -> new AbstractMap.SimpleEntry<>(m.getId() + "String10", m)).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        println(newMap);
    }

    @Override
    protected void filterModelsWithInteger1AndMapStringValuesFromThemToStringCollectionAndPrintIt() {
        List<String> strings = someModelCollection.stream().filter(m -> m.getIntValue() == 1).map(m -> m.getStringValue()).collect(Collectors.toList());
        print(strings);
    }
}
