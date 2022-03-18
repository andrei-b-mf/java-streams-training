package com.andreibu.solutions;

import com.andreibu.base.StreamsBase;
import com.andreibu.models.SomeModel;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamsFilterSolutions extends StreamsBase {
    @Override
    protected void runInternal() {
        println("printAllModelsWithIntValueEqualsToOneUsingPrintMethodFromBase");
        printAllModelsWithIntValueEqualsToOneUsingPrintMethodFromBase();
        println("printAllModelsWithIntValueEqualsToOneUsingForEachWithSystemOutInside");
        printAllModelsWithIntValueEqualsToOneUsingForEachWithSystemOutInside();
        println("printAllModelsWithFloatValueLessThanOrEqualsToThreeUsePredicateNegateUsingPrintMethodFromBase");
        printAllModelsWithFloatValueLessThanOrEqualsToThreeUsePredicateNegateUsingPrintMethodFromBase();
        println("printAllModelsWithIntEqualsToZeroAndFloatBiggerThan10SeparateFilterLambdasPerCondition");
        printAllModelsWithIntEqualsToZeroAndFloatBiggerThan10SeparateFilterLambdasPerCondition();
    }

    private void printAllModelsWithIntValueEqualsToOneUsingPrintMethodFromBase() {
        List<SomeModel> modelList = this.someModelCollection.stream().filter(e -> e.getIntValue() == 1).collect(Collectors.toList());

        println(modelList);
    }

    private void printAllModelsWithIntValueEqualsToOneUsingForEachWithSystemOutInside() {
        this.someModelCollection.stream().filter(e -> e.getIntValue() == 1).forEach(e -> System.out.println(e));
    }

    private void printAllModelsWithFloatValueLessThanOrEqualsToThreeUsePredicateNegateUsingPrintMethodFromBase() {
        LinkedList<SomeModel> modelsWithFloatLessThan = this.someModelCollection.stream()
                .filter(((Predicate<? super SomeModel>) (e -> e.getFloatValue() > 3.f)).negate())
                .collect(Collectors.toCollection(LinkedList::new));

        println(modelsWithFloatLessThan);
    }

    private void printAllModelsWithIntEqualsToZeroAndFloatBiggerThan10SeparateFilterLambdasPerCondition() {
        this.someModelCollection.stream()
                .filter(e -> e.getIntValue() == 0)
                .filter(e -> e.getFloatValue() > 10.0f)
                .forEach(e -> System.out.println(e));
    }
}
