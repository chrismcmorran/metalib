package graphs.convenience;

import graphs.visualization.GraphVisualization;
import org.jgrapht.GraphPath;

public interface GraphFeatures {
    GraphVisualization Visualize();
    <Vertex, Edge> GraphPath<Vertex, Edge> DijkstraShortestPath(org.jgrapht.Graph<Vertex, Edge> graph, Vertex source, Vertex destination);
}
