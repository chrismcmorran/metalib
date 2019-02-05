package graphs;

import graphs.convenience.DirectedWeightedGraph;
import graphs.convenience.WeightedEdge;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.*;

public class Graph {

    /**
     * Creates a Directed Weighted Graph.
     * @param <Vertex>
     * @return An empty DirectedWeightedGraph.
     */
    public <Vertex> DirectedWeightedGraph<Vertex, WeightedEdge> DirectedWeightedGraph() {
        return new DirectedWeightedGraph<>(WeightedEdge.class);
    }

    /**
     * Creates a new Undirected Graph using JGraphT.
     * @return An empty DefaultUndirectedGraph.
     */
    public <Vertex> DefaultUndirectedGraph<Vertex, DefaultEdge> DefaultUndirectedGraph() {
        return new DefaultUndirectedGraph<>(DefaultEdge.class);
    }

    /**
     * Creates a new Undirected Weighted Graph using JGraphT.
     * @return An empty DefaultUndirectedWeightedGraph.
     */
    public <Vertex> DefaultUndirectedWeightedGraph<Vertex, DefaultWeightedEdge> DefaultUndirectedWeightedGraph() {
        return new DefaultUndirectedWeightedGraph<>(DefaultWeightedEdge.class);
    }

    /**
     * Creates a new Default Directed Graph using JGraphT.
     * @return An empty DefaultDirectedGraph.
     */
    public <Vertex> DefaultDirectedGraph<Vertex, DefaultEdge> DefaultDirectedGraph() {
        return new DefaultDirectedGraph<>(DefaultEdge.class);
    }

    /**
     * Creates a new Directed Weighted Graph using JGraphT.
     * @return An empty DefaultDirectedWeightedGraph.
     */
    public <Vertex> DefaultDirectedWeightedGraph<Vertex, DefaultWeightedEdge> DefaultDirectedWeightedGraph() {
        return new DefaultDirectedWeightedGraph<>(DefaultWeightedEdge.class);
    }

    /**
     * Computes Dijkstra's Shortest Path from a source node to a destination node.
     * @param graph The graph to use. It must not contain negative weights.
     * @param source The source node.
     * @param destination The destination node.
     * @param <Vertex> The source type.
     * @param <Edge> The edge type.
     * @return A JGraphT GraphPath<Vertex, Edge>.
     */
    public <Vertex, Edge> GraphPath<Vertex, Edge> DijkstraShortestPath(org.jgrapht.Graph<Vertex, Edge> graph, Vertex source, Vertex destination) {
        return DijkstraShortestPath.findPathBetween(graph, source, destination);
    }

}
