package pl.zynis.algorithmtasks;

import pl.zynis.algorithmtasks.services.InputService;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static pl.zynis.algorithmtasks.services.InputService.getInputInt;

public class FindSeparatedGraphsApp {
    private final Map<Integer, Set<Integer>> vertexes = new HashMap<>();

    public void addVertexes(int first, int second) {
        if (vertexes.containsKey(first)) {
            vertexes.get(first).add(second);
        } else {
            vertexes.put(first, new HashSet<>(Collections.singletonList(second)));
        }

        if (vertexes.containsKey(second)) {
            vertexes.get(second).add(first);
        } else {
            vertexes.put(second, new HashSet<>(Collections.singletonList(first)));
        }
    }

    private void searchTree(int v, Set<Integer> visitedVertex) {
        visitedVertex.add(v);

        for (int x : vertexes.get(v)) {
            if (!visitedVertex.contains(x)) {
                searchTree(x, visitedVertex);
            }
        }
    }

    public int getGraphCount() {
        int graphCount = 0;
        Set<Integer> visitedVertex = new HashSet<>();

        for (int v : vertexes.keySet()) {
            if (!visitedVertex.contains(v)) {
                graphCount++;
                searchTree(v, visitedVertex);
            }
        }

        return graphCount;
    }

    public static void main(String[] args){
        System.out.println("Enter input: ");
        int n = getInputInt();

        FindSeparatedGraphsApp app = new FindSeparatedGraphsApp();

        IntStream.range(0, n).forEach(i -> {
            String[] input = InputService.getInputInts();

            List<Integer> connection = InputService.validAndGetInputStream(input).collect(Collectors.toList());
            app.addVertexes(connection.get(0), connection.get(1));
        });


        System.out.println("Output: ");
        System.out.println(app.getGraphCount());
    }
}