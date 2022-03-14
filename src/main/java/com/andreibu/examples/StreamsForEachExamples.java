package com.andreibu.examples;

import com.andreibu.models.SomeModel;

import java.util.ArrayList;
import java.util.Collection;

public class StreamsForEachExamples implements Runnable {

    @Override
    public void run() {
        Collection<SomeModel> someModelCollection = new ArrayList<>();
        someModelCollection.add(new SomeModel(0, "1", 2.f));
        someModelCollection.add(new SomeModel(1, "2", 3.f));

        System.out.println("Parallel stream:");
        someModelCollection.parallelStream().forEach(e -> {
            System.out.println(e.toString());
        });

        System.out.println("Sequential streams forEach:");
        someModelCollection.stream().forEach(e -> {
            System.out.println(e.toString());
        });

        System.out.println("Simple forEach:");
        someModelCollection.forEach(e -> {
            System.out.println(e.toString());
        });

        // Difference:

        // The forEach version:
        //  is just a syntactic sugar around a simple for loop.
        //  The lambda is taken as a functional consumer interface and applied for each element.
        //  Usually the order of the elements is preserved (if the implementing class does not specify something different)
        //  Data inside the iterated list can be modified, but not deleted, as this will result in ConcurrentModificationException.
        //  Removing an element will produce a java.util.ConcurrentModificationException
        //  Uncomment below to see the actual result
        //exampleRemoveFromForEach(someModelCollection);

        // The streams version:
        //  Is based on the stream interface rather than Iterable
        //  The execution order is not defined.
        //  For parallel version a spliterator is used.
        //  Streams should not modify existing objects. The concept of stream is to do something with the data, and create new data from it.
        //  Parallel execution is not guaranteed. The JVM might decide that there is no point running in parallel and will run sequentially.
        //  Removing elements from a stream will lead to unexpected behavior
        //  Uncomment below to see the actual result
        //exampleRemoveFromStreamForEach(someModelCollection);
    }

    private void exampleRemoveFromStreamForEach(Collection<SomeModel> someModelCollection) {
        someModelCollection.stream().forEach(e -> {
            System.out.println("Removing element within stream: " + e.toString());
            someModelCollection.remove(e);
            System.out.println("Removed element within stream: " + e.toString());
        });
    }

    private void exampleRemoveFromForEach(Collection<SomeModel> someModelCollection) {
        someModelCollection.forEach(e -> {
            System.out.println("Removing element within forEach: " + e.toString());
            someModelCollection.remove(e);
            System.out.println("Removed element within stream: " + e.toString());
        });
    }
}
