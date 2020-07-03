package pl.zynis.algorithmtasks;

import pl.zynis.algorithmtasks.services.InputService;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class SortAscApp {

    public static void main(String[] args) {
        System.out.println("Enter input");
        String[] input = InputService.getInputInts();
        Supplier<Stream<Integer>> sortedDistinctList = () -> InputService.validAndGetInputStream(input).parallel().distinct().sorted();

        System.out.println("Output: ");

        System.out.println(Arrays.toString(sortedDistinctList.get().toArray()));
        System.out.println("count: " + input.length);
        System.out.println("distinct: " + sortedDistinctList.get().count());
        System.out.println("min: " + sortedDistinctList.get().min(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new));
        System.out.println("max: " + sortedDistinctList.get().max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new));
    }
}
