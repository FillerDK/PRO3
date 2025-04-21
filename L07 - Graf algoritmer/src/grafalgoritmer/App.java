package grafalgoritmer;

public class App {
    public static void main(String[] args) {
        Graph<Integer> graph = new EdgeListGraph<>();

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

        //System.out.println("DFS: " + GraphAlgortihms.dfs(graph, 123));
        //System.out.println("BFS: " + GraphAlgortihms.bfs(graph, 123));
        //System.out.println("Connected: " + GraphAlgortihms.connected(graph));
        System.out.println(GraphAlgortihms.mst(graph));
    }
}
