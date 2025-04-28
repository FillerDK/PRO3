package graphimplementationStuderende;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdjacencyMatrixGraph<V> implements Graph<V> {

    private Map<V, Integer> vertices = new HashMap<V, Integer>(); // Store vertices with index as value

    private Edge<V>[][] matrix;
    private int vertexNr; // Next vertex index to use
    private int numEdges;  // Number of edges in the Graph

    private static final int N = 15;

    /**
     * Construct an empty graph
     */
    public AdjacencyMatrixGraph() {
        matrix = (Edge<V>[][]) new Edge[N][N];
        vertexNr = 0;
    }

    @Override
    /** Return the number of vertices in the graph */
    public int numVertices() {
        return vertices.size();
    }

    @Override
    /** Return the number of edges in the graph */
    public int numEdges() {
        return numEdges;
    }

    @Override
    /** Return a list with the vertices in the graph. */
    public List<V> vertices() {
        return new ArrayList<>(vertices.keySet());
    }

    @Override
    /** Return a list with the edges in the graph. */
    public List<Edge<V>> edges() {
        List<Edge<V>> toReturn = new ArrayList<>();
        for (int i = 0; i < vertexNr; i++) {
            for (int j = i + 1; j < vertexNr; j++) {
                if (matrix[i][j] != null) {
                    toReturn.add(matrix[i][j]);
                }
            }
        }
        return toReturn;
    }

    @Override
    /**
     * Return a list with the neighbors of the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public List<V> neighbors(V v) {
        // TODO

        // Find the index of the vertex
        int vind = vertices.get(v);
        List<V> neighbors = new ArrayList<>();

        // Loop through the matrix to find the neighbors
        for (int i = 0; i < vertexNr; i++) {
            if (matrix[vind][i] != null) {
                // Add the neighbor to the list
                for (Map.Entry<V, Integer> entry : vertices.entrySet()) {
                    if (entry.getValue() == i) {
                        neighbors.add(entry.getKey());
                    }
                }
            }
        }

        return neighbors;
    }

    @Override
    /**
     * Return the incident edges to the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public List<Edge<V>> incidentEdges(V v) {
        //TODO

        // Find the index of the vertex
        int vind = vertices.get(v);
        List<Edge<V>> incidentsEdges = new ArrayList<>();

        // Loop through the matrix to find the incident edges
        for (int i = 0; i < vertexNr; i++) {
            if (matrix[vind][i] != null) {
                incidentsEdges.add(matrix[vind][i]);
            }
        }

        return incidentsEdges;
    }

    @Override
    /**
     * Return the degree for the specified vertex.
     * Pre: The vertex is in the graph.
     */
    public int degree(V v) {
        // TODO

        // Find the index of the vertex
        int vind = vertices.get(v);
        int degree = 0;

        // Loop through the matrix to find the degree
        for (int i = 0; i < vertexNr; i++) {
            if (matrix[vind][i] != null) {
                degree++;
            }
        }

        return degree;
    }

    @Override
    /**
     * Return true, if the specified vertices are neighbors.
     * Pre: The vertices are vertices in the graph.
     */
    public boolean areAdjacent(V v, V u) {
        // TODO

        // Find the indices of the vertices
        int vind = vertices.get(v);
        int uind = vertices.get(u);

        // Check if the edge exists in the matrix
        if (matrix[vind][uind] != null) {
            return true;
        }

        return false;
    }

    @Override
    /** Print the vertices and the edges. */
    public void printGraph() {
        // TODO

        // Print the vertices
        System.out.println("Vertices:");
        for (V vertex : vertices.keySet()) {
            System.out.print(vertex + " ");
        }
    }

    @Override
    /**
     * Add a vertex to the graph.
     * Pre: The vertex is not in the graph before this addition.     */
    public void addVertex(V v) {
        // TODO

        // Check if matrix needs to be expanded
        if (vertexNr == matrix.length) {
            // Expand the matrix
            Edge<V>[][] newMatrix = (Edge<V>[][]) new Edge[matrix.length * 2][matrix.length * 2];
            // Copy the old matrix to the new matrix
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    newMatrix[i][j] = matrix[i][j];
                }
            }
            // Initialize the new part of the matrix
            matrix = newMatrix;
        }

        // Add the new vertex to the matrix
        vertices.put(v, vertexNr);
        vertexNr++;
    }

    @Override
    /**
     * Add an edge with weight 0 between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     */
    public void addEdge(V v, V u) {
        // TODO

        // Add the edge to the matrix
        int vind = vertices.get(v);
        int uind = vertices.get(u);
        matrix[vind][uind] = matrix[uind][vind] = new Edge<>(u, v, 0);
        numEdges++;
    }

    @Override
    /**
     * Add an edge with the specified weight between the specified vertices to the graph.
     * Pre: Before addition, the vertices are in the graph, and the edge is not in the graph.
     * Pre: The weight is not negative.
     */
    public void addEdge(V v, V u, int e) {
        //TODO

        // Add the edge to the matrix
        int vind = vertices.get(v);
        int uind = vertices.get(u);
        matrix[vind][uind] = matrix[uind][vind] = new Edge<>(u, v, e);
        numEdges++;
    }

    @Override
    /**
     * Remove the specified vertex from the graph.
     * Pre: The vertex is in the graph
     */
    public void removeVertex(V v) {
        //TODO

        // Remove the vertex from the matrix
        int vind = vertices.get(v);
        vertices.remove(v);

        // Removes the vertex from the matrix
        for (int i = 0; i < vertexNr; i++) {
            matrix[vind][i] = null;
            matrix[i][vind] = null;
        }

        // Shift the vertices down
        for (int i = vind; i < vertexNr - 1; i++) {
            for (int j = 0; j < vertexNr; j++) {
                matrix[i][j] = matrix[i + 1][j];
                matrix[j][i] = matrix[j][i + 1];
            }
        }
        vertexNr--;
    }

    @Override
    /**
     * Remove the edge between the specified vertices from the graph.
     * Pre: The vertices are vertices in the graph,
     *   and The graph has an edge between the vertices.
     */
    public void removeEdge(V v, V u) {
        //TODO

        // Remove the edge from the matrix
        int vind = vertices.get(v);
        int uind = vertices.get(u);
        matrix[vind][uind] = matrix[uind][vind] = null;
        numEdges--;
    }

}

