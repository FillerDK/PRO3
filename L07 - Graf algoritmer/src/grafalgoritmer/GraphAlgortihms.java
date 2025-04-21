package grafalgoritmer;

import java.util.*;

public class GraphAlgortihms {
    /**
     * Returnerer en liste af grafens knuder fundet ved et dybddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> dfs(Graph<V> graph, V v) {
        // TODO Opgave 2

        List<V> result = new ArrayList<>();
        // Marker v som besøgt
        result.add(v);
        // For alle v's naboer w
        for (V w : graph.neighbors(v)) {
            // Hvis w ikke er besøgt
            if (!result.contains(w)) {
                dfs(graph, w, result);
            }
        }

        return result;
    }

    private static <V> void dfs(Graph<V> graph, V v, List<V> res) {
        // Marker v som besøgt
        res.add(v);
        // For alle v's naboer w
        for (V w : graph.neighbors(v)) {
            // Hvis w ikke er besøgt
            if (!res.contains(w)) {
                dfs(graph, w, res);
            }
        }
    }

    /**
     * Returnerer en liste af grafens knuder fundet ved et breddeførst gennemløb af
     * grafen med startknude v.
     */
    public static <V> List<V> bfs(Graph<V> graph, V v) {
        // TODO Opgave 3

        List<V> visited = new ArrayList<>();
        List<V> queue = new LinkedList<>();

        // Indsæt (v) i køen
        queue.add(v);

        // Så længe køen ikke er tom
        while (!queue.isEmpty()) {
            // Lad w være den første knude i køen
            V w = queue.getFirst();
            // Fjern w fra køen og indsæt w i listen af besøgte knuder
            queue.remove(w);
            visited.add(w);
            // For alle w's naboknuder u
            for (V u : graph.neighbors(w)) {
                // Hvis u ikke er besøgt og ikke er med i køen
                if (!visited.contains(u) && !queue.contains(u)) {
                    // Indsæt (u) i køen
                    queue.add(u);
                }
            }
        }

        return visited;
    }

    /**
     * Returnerer om grafen er sammenhængende
     * Pre: grafen er ikke tom
     */
    public static <V> boolean connected(Graph<V> graph) {
        // TODO Opgave 4

        return bfs(graph, graph.vertices().getFirst()).size() == graph.numVertices();
    }

    /**
     * Returnerer om der er en vej fra v1 til v2 i graph
     */
    public static <V> boolean isPath(Graph<V> graph, V v1, V v2) {
        // TODO Opgave 5

        return bfs(graph, v1).contains(v2); // ikke optimeret, brug evt. bfs så vi undgår dobbelt gennemløb
    }

    /**
     * Returnerer en mængde af grafens kanter der udgør det letteste udspændende træ for grafen.
     * Grafen er en simpel vægtet graf
     */
    public static <V> Set<Edge> mst(Graph<V> G) {
        // TODO Opgave 7

        Set<Edge> T = new HashSet<>();

        Map<V, List<V>> c = new HashMap();

        // For alle v i G
        for (V v : G.vertices()) {
            // C(v) = [{v},...], den mængde som knuden v er i
            List<V> list = new ArrayList<>();
            list.add(v);
            c.put(v, list);
        }
        // Q = prioritetskø indeholdende alle kanter priotiteret efter vægt
        PriorityQueue<Edge<V>> Q = new PriorityQueue<>();
        for (Edge<V> e : G.edges()) {
            Q.add(e);
        }
        // T = Ø
        // Så længe T har færre end n-1 kanter
        while (T.size() < G.numEdges()-1) {
            // e = Q.removeMin();
            Edge e = Q.poll();
            // Lad u og v betegne e's endepunkter
            // Hvis C(u) != C(v)
            if (c.get(e.getU()) != c.get(e.getV())) {
                System.out.println("U: " + c.get(e.getU()));
                System.out.println("V: " + c.get(e.getV()));
                // T.add(e)
                T.add(e);
                // C(u) = C(u) U C(v)
                c.get(e.getU()).add((V) e.getV());
                // Fjern mængden C(v)
                c.remove(e.getV());
            }
        }

        return T;
    }

}
