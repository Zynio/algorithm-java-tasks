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
        Supplier<Stream<Integer>> numbers = () -> InputService.validAndGetInputStream(input).parallel().distinct().sorted();

        System.out.println("Output: ");

        System.out.println(Arrays.toString(numbers.get().toArray()));
        System.out.println("count: " + input.length);
        System.out.println("distinct: " + numbers.get().count());
        System.out.println("min: " + numbers.get().min(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new));
        System.out.println("max: " + numbers.get().max(Comparator.naturalOrder()).orElseThrow(NoSuchElementException::new));
    }
}
