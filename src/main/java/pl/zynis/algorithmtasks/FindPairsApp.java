package pl.zynis.algorithmtasks;

import pl.zynis.algorithmtasks.services.InputService;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindPairsApp {

    private static final int SUM = 13;

    public static void main(String[] args) {
        System.out.println("Enter input: ");
        String[] input = InputService.getInputInts();

        List<Integer> numbers = InputService.validAndGetInputStream(input).sorted().collect(Collectors.toList());

        System.out.println("Output: ");

        numbers.forEach(
                i -> IntStream.range(0,  numbers.size()).parallel()
                        .filter(j -> i + numbers.get(j)== SUM && i < numbers.get(j))
                        .forEach(j -> System.out.println(numbers.get(i) + " " + numbers.get(j)))
                );
    }
}
