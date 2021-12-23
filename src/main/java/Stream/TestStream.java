package Stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {
    public static List<Integer> iterateSeparately() {
        List<Integer> integers = new ArrayList<>(Collections.nCopies(100000, 1000));
        return integers.stream().map(i -> i + 2)
                .map(i -> i / 2)
                .map(i -> i *3 /2)
                .collect(Collectors.toList());
    }

    public static List<Integer> iterateCombined() {
        List<Integer> integers = new ArrayList<>(Collections.nCopies(0, 1000));
        return integers.stream().map(i -> ((i + 2) / 2) * 3 /2)
                .collect(Collectors.toList());
    }

    public static List<Integer> smartOptimizationOfStream() {
        Set<Integer> integers = new HashSet<>(Arrays.asList(1, 2, 3, 6, 2, 3));
        return integers.stream()
                .map(i -> ((i + 2) / 2) * 3 /2)
                .distinct() // Stream smart that will skip this step
                .collect(Collectors.toList());
    }

    public static List<Integer> statelessOpExp() {
        List<Integer> integers = Arrays.asList(4, 2, 3, 2, 1);
        return integers.stream()
                .filter(i -> {
                    System.out.print("Filtering " + i + "\n");
                    return  i % 2 == 0;
                })
                .map(i -> {
                    System.out.print("Mapping " + i + "\n");
                    return i * 2;
                })
                .collect(Collectors.toList());
    }

    public static List<Integer> stateFullOpExp() {
        List<Integer> integers = Arrays.asList(4, 2, 3, 2, 1);
        return integers.stream()
                .parallel()
                .filter(i -> {
                    System.out.print("Filtering " + i + "\n");
                    return  i % 2 == 0;
                })
                .sorted()
                .map(i -> {
                    System.out.print("Mapping " + i + "\n");
                    return i * 2;
                })
                .collect(Collectors.toList());
    }

    public static void exampleOfTraverseDistinctAndSort() {
        Stream<Integer> stream = Stream.of(2,1,3,5,3)
                .peek(i -> System.out.println("source: "+i))
                .sorted()
                .peek(i -> System.out.println("sorted: "+i))
                .distinct()
                .peek(i -> System.out.println("distinct: "+i));
        System.out.println("commencing terminal operation");
        stream.forEachOrdered(i -> System.out.println("terminal: "+i));
    }

    public static void example2OfTraverse() {
        Stream<Integer> stream = Stream.of(2,1,1,3,5,6,7,9,2,1,3,5,11,10)
                .peek(i -> System.out.println("source: "+i))
                .distinct()
                .peek(i -> System.out.println("distinct: "+i))
                .filter(i -> i>2)
                .peek(i -> System.out.println("Filtered: "+i));

//        stream.findFirst().ifPresent(i -> System.out.println("found: "+i));
        stream.forEachOrdered(i -> System.out.println("terminal: "+i));
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
//        System.out.print(stateFullOpExp());
        exampleOfTraverseDistinctAndSort();
//        example2OfTraverse();
        long finishTime = System.currentTimeMillis();
        System.out.println("That took: " + (finishTime - startTime) + " ms");
    }
}
