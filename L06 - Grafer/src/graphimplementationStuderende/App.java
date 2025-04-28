package graphimplementationStuderende;

import java.util.List;

public class App {
    public static void main(String[] args) {
        // opg3
//        Graph<Integer> graph = new AdjacencyListGraph<>();
        // opg1.a
        //EdgeListGraph<Integer> graph = new EdgeListGraph<>();
        // opg4
        AdjacencyMatrixGraph<Integer> graph = new AdjacencyMatrixGraph<>();

        graph.addVertex(15);
        graph.addVertex(38);
        graph.addVertex(6);
        graph.addVertex(123);
        graph.addVertex(66);

        graph.addEdge(15, 38, 10);
        graph.addEdge(15, 6, 23);
        graph.addEdge(15, 66, 90);

        graph.addEdge(38, 123, 55);
        graph.addEdge(38, 66, 2);

        graph.addEdge(6, 123, 7);
        graph.addEdge(6, 66, 8);

        graph.addEdge(123, 66, 76);

        // opg1.b
        graph.printGraph();
        System.out.println();

        System.out.println("6's degree: " + graph.degree(6));
        System.out.println("6's neighbors: " + graph.neighbors(6));
        System.out.println("6's incident edges: " + graph.incidentEdges(6));
        System.out.println();

        // opg1.c
        System.out.println("Biggest vertex in graph: " + findBiggestVertex(graph));
        System.out.println();

        // opg3
        System.out.println("Edges: " + graph.edges());
        System.out.println("15, 123, are adjecent: " + graph.areAdjacent(15, 123));
        System.out.println("15, 6, are adjecent: " + graph.areAdjacent(15, 6));
        System.out.println();

        System.out.println("Before changes...");
        graph.printGraph();
        System.out.println();

        System.out.println("Removing edge between 15 and 6...");
        graph.removeEdge(15, 6);
        graph.printGraph();
        System.out.println();

        System.out.println("Removing vertex '6'...");
        graph.removeVertex(6);
        graph.printGraph();
        System.out.println();
    }

    public static <V extends Comparable<V>> V findBiggestVertex(Graph<V> graph) {
        V biggest = graph.vertices().get(0);

        for (V vertex : graph.vertices()) {
            biggest = biggest.compareTo(vertex) < 0 ? vertex : biggest;
        }

        return biggest;
    }
}
