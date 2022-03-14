package com.andreibu;

import com.andreibu.examples.StreamsFilterExamples;
import com.andreibu.examples.StreamsForEachExamples;
import com.andreibu.examples.StreamsMapExamples;
import com.andreibu.solutions.StreamsMapSolutions;

import java.util.*;
import java.util.stream.Stream;

public class Main {

	private static class ChangeSet {

		public boolean isNew() {
			return false;
		}
	}

	public static void main(String[] args) {
		getTestId("test 1");
		run();
//		System.out.println("Running streams foreach examples");
//		StreamsForEachExamples streamsForEachExamples = new StreamsForEachExamples();
//        streamsForEachExamples.run();
//
//        System.out.println("Running streams filtering examples");
//		StreamsFilterExamples streamsFilterExamples = new StreamsFilterExamples();
//		streamsFilterExamples.run();

//		System.out.println("Running streams map examples");
//		StreamsMapExamples streamsMapExamples = new StreamsMapExamples();
//		streamsMapExamples.run();

		System.out.println("Running streams map solutions");
		StreamsMapSolutions streamsMapSolutions = new StreamsMapSolutions();
		streamsMapSolutions.run();

		int i = parseInt("zero");
		System.out.println(i);
	}

	private static void run() {
		List<ChangeSet> changeSets = new ArrayList<>();
		//changeSets.add(new ChangeSet());

		final Optional<Boolean> isCreateEntity = changeSets.stream().map(ChangeSet::isNew).reduce((a, b) -> a && b);
		if (!isCreateEntity.isPresent()) {
			return;
		}
	}

	private static String getTestId(String step) {
		String[] strings = step.split(" ");
		if (strings.length < 2) {
			throw new RuntimeException("business_error.export_import_index_out_of_bound_test_step");
		} else {
			return strings[0];
		}
	}

	public static int parseInt(String s1) {
		Stack s = new Stack();
//		for(int i = 0; i < 10_000_000; i++) {
//			s.push(i);
//		}

		Stack s2 = new Stack();
//		for(int i = 0; i < 10_000_000; i++) {
//			s2.push(i);
//		}

		long t = System.nanoTime();
		for(int i = 0; i < s.size() + 1; i++) {
			if(!s.empty()) {
				s.pop();
			}
		}

		System.out.println("empty check: " + (System.nanoTime() - t));

		t = System.nanoTime();
		for(int i = 0; i < s.size() + 1; i++) {
			try {
				s2.pop();
			} catch(EmptyStackException e) {

			}
		}

		System.out.println("Exception pop: " + (System.nanoTime() - t));

		return 0;
	}
}