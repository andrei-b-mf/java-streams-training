package com.andreibu.solutions;

import com.andreibu.base.StreamsBase;

import java.util.List;
import java.util.stream.Collectors;

public class StreamsMapSolutions extends StreamsBase {
    @Override
    public void run() {
        initialize();

        println("transformModelsIntoACollectionOfIntegersUsingIntValueAndPrintIt");
        transformModelsIntoACollectionOfIntegersUsingIntValueAndPrintIt();
        println("transformModelsIntoACollectionOfDoublesUsingFloatValueAndPrintIt");
        transformModelsIntoACollectionOfDoublesUsingFloatValueAndPrintIt();
        println("transformModelsIntoAnArrayOfLongsUsingLongValueAndPrintIt");
        transformModelsIntoAnArrayOfLongsUsingLongValueAndPrintIt();
        println("buildNewSomeModelCollectionWithZeroIntegerValueAndPrintIt");
        buildNewSomeModelCollectionWithZeroIntegerValueAndPrintIt();
        println("buildNewStringModelCollectionUsingStringValueAddingAPrefixAndPrintIt");
        buildNewStringModelCollectionUsingStringValueAddingAPrefixAndPrintIt();
        println("buildNewSomeModelMapWhereKeyIsTheIDPlusString10AndPrintIt");
        buildNewSomeModelMapWhereKeyIsTheIDPlusString10AndPrintIt();
        println("filterModelsWithInteger1AndMapStringValuesFromThemToStringCollectionAndPrintIt");
        filterModelsWithInteger1AndMapStringValuesFromThemToStringCollectionAndPrintIt();
    }

    private void transformModelsIntoACollectionOfIntegersUsingIntValueAndPrintIt() {
        List<Integer> integers = someModelCollection.stream().map(m -> m.getIntValue()).collect(Collectors.toList());
        print(integers);
        integers = someModelCollection.stream().mapToInt(m -> m.getIntValue()).boxed().collect(Collectors.toList());
        print(integers);
    }

    private void transformModelsIntoACollectionOfDoublesUsingFloatValueAndPrintIt() {
        List<Double> doubles = someModelCollection.stream().mapToDouble(m -> m.getFloatValue()).boxed().collect(Collectors.toList());
        print(doubles);
    }

    private void transformModelsIntoAnArrayOfLongsUsingLongValueAndPrintIt() {
        long[] longs = someModelCollection.stream().mapToLong(m -> m.getIntValue()).toArray();
        print(longs);
    }

    private void buildNewSomeModelCollectionWithZeroIntegerValueAndPrintIt() {

    }

    private void buildNewStringModelCollectionUsingStringValueAddingAPrefixAndPrintIt() {
        // TODO Implement
    }

    private void buildNewSomeModelMapWhereKeyIsTheIDPlusString10AndPrintIt() {
        // TODO Implement
    }

    private void filterModelsWithInteger1AndMapStringValuesFromThemToStringCollectionAndPrintIt() {
        // TODO Implement
    }
}
