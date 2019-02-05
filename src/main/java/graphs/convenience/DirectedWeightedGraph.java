package graphs.convenience;


import graphs.visualization.GraphVisualization;
import jdkreplacement.ArrayList;
import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;

import java.util.function.Supplier;

public class DirectedWeightedGraph<Vertex, Edge> extends org.jgrapht.graph.DefaultDirectedWeightedGraph<Vertex, Edge> implements GraphFeatures{
    public DirectedWeightedGraph(Class<? extends Edge> edgeClass) {
        super(edgeClass);
    }

    public DirectedWeightedGraph(Supplier<Vertex> vertexSupplier, Supplier<Edge> edgeSupplier) {
        super(vertexSupplier, edgeSupplier);
    }

    /**
     * Gets a list of all of the vertices in the graph.
     * @return List<Vertex>
     */
    public ArrayList<Vertex> VertexList() {
        return new ArrayList<>(this.vertexSet());
    }

    /**
     * Gets a list of all of the edges in the graph.
     * @return List<Edge>.
     */
    public ArrayList<Edge> EdgeList() {
        return new ArrayList<>(this.edgeSet());
    }

    /**
     * Computes Dijkstra's Shortest Path between the source and destination.
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @return GraphPath<Vertex, Edge>
     */
    public GraphPath<Vertex, Edge> DijkstraShortestPath(Vertex source, Vertex destination) {
        return DijkstraShortestPath.findPathBetween(this, source, destination);
    }

    /**
     * Adds a vertex to the graph.
     * @param vertex The vertex to add.
     * @return This Graph.
     */
    public DirectedWeightedGraph<Vertex, Edge> AddVertex(Vertex vertex) {
        this.addVertex(vertex);
        return this;
    }

    public DirectedWeightedGraph<Vertex, Edge> Edge(Vertex source, Vertex destination, double weight) {
        Edge edge = this.addEdge(source, destination);
        this.setEdgeWeight(edge, weight);
        return this;
    }

    @Override
    public GraphVisualization Visualize() {
        return new GraphVisualization<Vertex, Edge>(this);
    }

    @Override
    public <Vertex, Edge> GraphPath<Vertex, Edge> DijkstraShortestPath(Graph<Vertex, Edge> graph, Vertex source, Vertex destination) {
        return DijkstraShortestPath.findPathBetween(graph, source, destination);
    }
}
