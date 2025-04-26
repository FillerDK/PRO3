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

        List<V> visited = new ArrayList<>();
        List<V> queue = new LinkedList<>();
        boolean pathExists = false;

        // Indsæt (v) i køen
        queue.add(v1);

        do {
            // Lad w være den første knude i køen
            V w = queue.getFirst();

            if (w.equals(v2)) {
                pathExists = true;
            }

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
        // Så længe køen ikke er tom
        } while (!queue.isEmpty() && !pathExists);

        return pathExists;
    }

    /**
     * Returnerer en mængde af grafens kanter der udgør det letteste udspændende træ for grafen.
     * Grafen er en simpel vægtet graf
     */
    public static <V> Set<Edge<V>> mst(Graph<V> G) {
        Set<Edge<V>> T = new HashSet<>();

        // Hver knude har en separat komponent-liste
        Map<V, List<V>> c = new HashMap<>();
        for (V v : G.vertices()) {
            List<V> list = new ArrayList<>();
            list.add(v);
            c.put(v, list);
        }

        // Prioritetskø med alle kanter
        PriorityQueue<Edge<V>> Q = new PriorityQueue<>(G.edges());

        // Så længe vi har færre end n - 1 kanter i træet
        while (T.size() < G.vertices().size() - 1 && !Q.isEmpty()) {
            Edge<V> e = Q.poll();
            V u = e.getU();
            V v = e.getV();

            List<V> cu = c.get(u);
            List<V> cv = c.get(v);

            // Hvis u og v ikke er i samme komponent
            if (cu != cv) {
                T.add(e);

                // Slå komponenterne sammen
                cu.addAll(cv);

                // Opdater c-map: alle v'er i cv skal nu pege på cu
                for (V x : cv) {
                    c.put(x, cu);
                }
            }
        }

        return T;
    }

    /**
     * Returnerer en map med den korteste afstand fra start til alle andre knuder i grafen.
     * Grafen er en simpel vægtet graf
     */
    public static <V> Map<V, Integer> dijkstra(Graph<V> G, V start) {
        // 1. Afstande: D[v] = 0, resten = uendelig (fx Integer.MAX_VALUE)
        Map<V, Integer> D = new HashMap<>();
        for (V v : G.vertices()) {
            if (v.equals(start)) {
                D.put(v, 0);
            } else {
                D.put(v, Integer.MAX_VALUE);
            }
        }

        // 2. Priority queue med Comparator baseret på D[v]
        PriorityQueue<V> Q = new PriorityQueue<>(Comparator.comparingInt(D::get));
        Q.addAll(G.vertices());

        // 3. Så længe Q ikke er tom
        while (!Q.isEmpty()) {
            // 4. Fjern knuden med kortest afstand
            V u = Q.poll();

            // 5. For hver nabo z til u, som stadig er i Q
            for (V z : G.neighbors(u)) {
                if (Q.contains(z)) {
                    // 6. Hent vægten af kanten (u, z)
                    int weight = findEdgeWeight(u, z, G);

                    // 7. Relaxation: hvis D[u] + vægt < D[z] → opdater
                    if (D.get(u) + weight < D.get(z)) {
                        D.put(z, D.get(u) + weight);

                        // 8. "Opdater" z i priority queue (ved at fjerne og tilføje igen)
                        Q.remove(z);
                        Q.add(z);
                    }
                }
            }
        }
        return D;
    }

    /**
     * Returnerer vægten af kanten mellem u og z i grafen G.
     * Returnerer -1, hvis kanten ikke findes.
     */
    public static <V> int findEdgeWeight(V u, V z, Graph<V> G) {
        for (Edge<V> e : G.edges()) {
            if ((e.getV().equals(u) && e.getU().equals(z)) ||
                (e.getU().equals(u) && e.getV().equals(z))) {
                return e.getElement();
            }
        }
        return -1;
    }

}
