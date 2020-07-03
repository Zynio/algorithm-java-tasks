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

        List<Integer> sortedList = InputService.validAndGetInputStream(input).sorted().collect(Collectors.toList());

        System.out.println("Output: ");

        sortedList.forEach(
                i -> IntStream.range(0,  sortedList.size())
                        .filter(j -> i + sortedList.get(j)== SUM && i < sortedList.get(j))
                        .forEach(j -> System.out.println(sortedList.get(i) + " " + sortedList.get(j)))
                );
    }
}
