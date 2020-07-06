package pl.zynis.algorithmtasks;

import pl.zynis.algorithmtasks.services.InputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPairsApp {

    private static final int SUM = 13;

    public static void main(String[] args) {
        System.out.println("Enter input: ");

        String[] input = InputService.getInputInts();

        System.out.println("Output: ");

        List<Vector<Integer>> pairs = getPairs(input);

        pairs.forEach(pair -> {
            System.out.println(pair.get(0) + " " + pair.get(1));
        });
    }

    public static List<Vector<Integer>> getPairs(String[] input) {
        List<Integer> numbers = InputService.validAndGetInputStream(input).sorted().collect(Collectors.toList());
        List<Vector<Integer>> pairs = new ArrayList<>();

        numbers.forEach(
                i -> IntStream.range(0,  numbers.size()).parallel()
                        .filter(j -> i + numbers.get(j) == SUM && i < numbers.get(j))
                        .forEach(j -> {
                            Vector<Integer> vector = new Vector();
                            vector.add(i);
                            vector.add(numbers.get(j));
                            pairs.add(vector);
                        })
        );

        return pairs;
    }
}
