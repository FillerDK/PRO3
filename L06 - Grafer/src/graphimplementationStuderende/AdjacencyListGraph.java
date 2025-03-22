package graphimplementationStuderende;

import java.util.*;

public class AdjacencyListGraph<V> implements Graph<V> {
    // List with all the vertices in the graph.
    private List<V> vertices;
    // Map with pairs containing (vertex, list of edges),
    // where list of edges is the incident edges to the vertex.
    // Note: Each edge is in 2 lists of incident edges.
    private Map<V, List<Edge<V>>> edges = new HashMap();

    /**
     * Construct an empty graph
     */
    public AdjacencyListGraph() {
        vertices = new ArrayList<>();
        edges = new LinkedHashMap<>();
    }

    @Override
    /** Return the number of vertices in the graph */
    public int numVertices() {
        return vertices.size();
    }

    @Override
    /** Return the number of edges in the graph */
    public int numEdges() {
        int size = 0;
        for (List<Edge<V>> list : edges.values()) {
            size += list.size();
        }
        return size / 2;
    }

    @Override
    /** Return the vertices in the graph */
    public List<V> vertices() {
        return new ArrayList<>(vertices);
    }

    @Override
    /** Return the edges in the graph */
    public List<Edge<V>> edges() {
        // TODO : lavet og testet

        List<Edge<V>> result = new ArrayList<>();

        for (int i = 0; i < vertices.size(); i++) {
            V vertex = vertices.get(i);
            List<Edge<V>> edgeList = edges.get(vertex);
            for (int j = 0; j < edgeList.size(); j++) {
                Edge<V> edge = edgeList.get(j);
                if (!result.contains(edge)) {
                    result.add(edge);
                }
            }
        }

        return result;
    }


    @Override
    /** Return the neighbors of the specified vertex */
    public List<V> neighbors(V v) {
        // TODO : lavet og testet

        List<V> neighbors = new ArrayList<>();
        List<Edge<V>> edgeList = new ArrayList<>(edges.get(v));

        for (int i = 0; i < edgeList.size(); i++) {
            Edge<V> edge = edgeList.get(i);
            neighbors.add(edge.oppositeVertex(v));
        }

        return neighbors;
    }


    @Override
    /** Return the incident edges of vertex v */
    public List<Edge<V>> incidentEdges(V v) {
        //TODO : lavet og testet

        return edges.get(v);
    }

    @Override
    /** Return the degree for a specified vertex */
    public int degree(V v) {
        //TODO : lavet og testet

        return edges.get(v).size();
    }

    @Override
    public boolean areAdjacent(V v, V u) {
        //TODO : lavet og testet

        List<Edge<V>> temp = edges.get(v);
        boolean found = false;

        for (int i = 0; !found && i < temp.size(); i++) {
            Edge<V> e = temp.get(i);
            if (e.oppositeVertex(v).equals(u)) {
                found = true;
            }
        }

        return found;
    }


    @Override
    /** Print the edges */
    public void printGraph() {
        for (V v : vertices) {
            List<Edge<V>> incidentEdges = edges.get(v);
            System.out.print("Vertex: " + v);
            System.out.println("\tIncident edges: " + incidentEdges);
        }
    }



    @Override
    /**
     * Add a vertex to the graph.
     * Pre: The vertex is not in the graph before this addition.     */
    public void addVertex(V v) {
        vertices.add(v);
    }

    @Override
    /**
     * Add an edge with weight 0 between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     */
    public void addEdge(V v, V u) {
        addEdge(v, u, 0);
    }

    @Override
    /** Add an edge to the graph */
    public void addEdge(V v, V u, int e) {
        //TODO : lavet og testet

        if (edges.get(v) == null) {
            edges.put(v, new ArrayList<>());
        }

        if (edges.get(u) == null) {
            edges.put(u, new ArrayList<>());
        }

        Edge<V> newEdge = new Edge<>(v, u, e);
        edges.get(v).add(newEdge);
        edges.get(u).add(newEdge);
    }


    @Override
    /**
     * Remove the specified vertex from the graph.
     * Pre: The vertex is in the graph
     */
    public void removeVertex(V v) {
        //TODO : lavet, men ikke testet

        List<Edge<V>> edgeList = edges.get(v);

        for (int i = 0; i < edgeList.size(); i++) {
            V u = edgeList.get(i).oppositeVertex(v);
            removeVertex(v, edges.get(u));
        }

        edges.remove(v);
        vertices.remove(v);
    }

    private void removeVertex(V v, List<Edge<V>> list) {
        //TODO : lavet, men ikke testet

        boolean removed = false;
        int i = 0;
        while (!removed) {
            Edge<V> edge = list.get(i);
            if (edge.getV().equals(v) ||
                    edge.getU().equals(v)) {
                list.remove(edge);
                removed = true;
            }
            i++;
        }
    }

    @Override
    /**
     * Remove the edge between the specified vertices from the graph.
     * Pre: The vertices are vertices in the graph,
     *   and The graph has an edge between the vertices.
     */
    public void removeEdge(V v, V u) {
        //TODO : lavet og testet

        List<Edge<V>> edgeVList = edges.get(v);
        boolean removed = false;
        int i = 0;

        while (!removed) {
            Edge<V> edge = edgeVList.get(i);
            if (edge.getV().equals(v) &&
                    edge.getU().equals(u)) {
                edgeVList.remove(edge);
                removed = true;
            }
            i++;
        }

        removed = false;
        i = 0;

        List<Edge<V>> edgeUList = edges.get(u);
        while (!removed) {
            Edge<V> edge = edgeUList.get(i);
            if (edge.getV().equals(v) &&
                    edge.getU().equals(u)) {
                edgeUList.remove(edge);
                removed = true;
            }
            i++;
        }
    }


}

