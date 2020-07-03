package pl.zynis.algorithmtasks;

import pl.zynis.algorithmtasks.services.InputService;

import java.util.*;
import java.util.stream.IntStream;

import static pl.zynis.algorithmtasks.services.InputService.getInputInt;

public class FindSeparatedGraphsApp {

    public static void main(String[] args) {
        List<Vector<Integer>> vectors = new ArrayList<>();
        List<Set<Integer>> groups = new ArrayList<>();

        System.out.println("Enter input: ");
        int n = getInputInt();

        IntStream.range(0, n).forEach(i -> {
            String[] input = InputService.getInputInts();

            Vector<Integer> vector = new Vector<>();
            InputService.validAndGetInputStream(input).forEach(vector::add);
            vectors.add(vector);
        });

        vectors.forEach(vector -> {
            boolean existInGroup = groups.stream().parallel()
                    .anyMatch(
                            group -> group.contains(vector.get(0)) || group.contains(vector.get(1))
                    );

            if (!existInGroup) {
                groups.add(new HashSet<>(vector));
            }
        });

        System.out.println("Output: ");
        System.out.println(groups.size());
    }
}
