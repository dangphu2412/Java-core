package Stream;

import java.util.*;
import java.util.stream.Collectors;

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
                    System.out.printf("Filtering: %s\n", i);
                    return i % 2 == 0;
                })
                .map(i -> {
                    System.out.printf("Mapping: %s\n", i);
                    return i * 2;
                })
                .collect(Collectors.toList());
    }

    public static List<Integer> stateFullOpExp() {
        List<Integer> integers = Arrays.asList(4, 2, 3, 2, 1);
        return integers.stream()
                .filter(i -> {
                    System.out.printf("Filtering: %s\n", i);
                    return i % 2 == 0;
                })
                .sorted()
                .map(i -> {
                    System.out.printf("Mapping: %s\n", i);
                    return i * 2;
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        System.out.print(stateFullOpExp());
        long finishTime = System.currentTimeMillis();
        System.out.println("That took: " + (finishTime - startTime) + " ms");
    }
}
