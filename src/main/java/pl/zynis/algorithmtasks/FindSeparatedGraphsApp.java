package pl.zynis.algorithmtasks;

import pl.zynis.algorithmtasks.services.InputService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.zynis.algorithmtasks.services.InputService.getInputInt;

public class FindSeparatedGraphsApp {

    public static void main(String[] args) {
        List<Set<Integer>> groups = new ArrayList<>();

        System.out.println("Enter input: ");
        int n = getInputInt();

        IntStream.range(0, n).forEach(i -> {
            String[] input = InputService.getInputInts();

            Vector<Integer> vector = new Vector<>();
            InputService.validAndGetInputStream(input).forEach(vector::add);

            Integer firstElement = vector.get(0);
            Integer secondElement = vector.get(1);

            List<Set<Integer>> subGroups = groups.stream()
                    .filter(integers -> integers.contains(firstElement) || integers.contains(secondElement))
                    .collect(Collectors.toList());

            if (subGroups.size() == 0) {
                groups.add(new HashSet<>(vector));
            } if (subGroups.size() == 1) {
                subGroups.get(0).add(firstElement);
                subGroups.get(0).add(secondElement);
            } if (subGroups.size() >= 2) {
                for (Set<Integer> element : subGroups.subList(1, subGroups.size())) {
                    subGroups.get(0).addAll(element);
                    groups.remove(element);
                }
            }
        });
        
        System.out.println("Output: ");
        System.out.println(groups.size());
    }
}
