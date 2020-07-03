package pl.zynis.algorithmtasks;

import pl.zynis.algorithmtasks.services.InputService;

import java.util.*;
import java.util.stream.IntStream;

import static pl.zynis.algorithmtasks.services.InputService.getInputInt;

public class FindSeparatedGraphsApp {

    public static void main(String[] args) {
        List<Vector<Integer>> vectors = new ArrayList<>();
        List<Set<Integer>> lists = new ArrayList<>();

        System.out.println("Enter input: ");
        int n = getInputInt();

        IntStream.range(0, n).forEach(i -> {
            String[] input = InputService.getInputInts();

            Vector<Integer> vector = new Vector<>();
            InputService.validAndGetInputStream(input).forEach(vector::add);
            vectors.add(vector);
        });

        vectors.forEach(vector -> {
            boolean existInGroup = lists.stream().parallel()
                    .anyMatch(
                            integers -> integers.contains(vector.get(0)) || integers.contains(vector.get(1))
                    );

            if (!existInGroup) {
                lists.add(new HashSet<>(vector));
            }
        });

        System.out.println("Output: ");
        System.out.println(lists.size());
    }
}
