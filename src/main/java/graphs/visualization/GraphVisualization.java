package graphs.visualization;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxCellRenderer;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxStylesheet;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class GraphVisualization<Vertex, Edge> extends Application {
    private Graph<Vertex, Edge> mGraphToVisualize;
    private JGraphXAdapter<Vertex, Edge> mGraphAdapter;
    private String mDisplayTitle;
    private static String imageFileFormat = "PNG";
    private static boolean graphIsSelectable = false;
    private static boolean graphIsLabeled = true;
    private static int nodeDistance = 30;
    private static int levelDistance = 60;
    private static int defaultImageHeight = 400;
    private static int defaultImageWidth = 400;

    public GraphVisualization(Graph<Vertex, Edge> graphToVisualize) {
        this.mGraphToVisualize = graphToVisualize;
        this.CreateVisualization();
        this.setDefaultProperties();
        this.mDisplayTitle = "Graph Visualization";
    }

    private void setDefaultProperties() {
        this.mGraphAdapter.setCellsSelectable(graphIsSelectable);
    }

    private void CreateVisualization() {
        mGraphAdapter = new JGraphXAdapter<>(mGraphToVisualize);
        mGraphAdapter.setStylesheet(GetDefaultStyleSheet());
        mxCircleLayout layout = new mxCircleLayout(mGraphAdapter);
        //layout.setNodeDistance(nodeDistance);
        //layout.setLevelDistance(levelDistance);
        layout.execute(mGraphAdapter.getDefaultParent());
    }

    private mxStylesheet GetDefaultStyleSheet() {
        Map<String, Object> edgeStyle = new HashMap<>();

        edgeStyle.put(mxConstants.STYLE_EDGE, mxConstants.EDGESTYLE_ORTHOGONAL);
        edgeStyle.put(mxConstants.STYLE_SHAPE,    mxConstants.SHAPE_CONNECTOR);
        edgeStyle.put(mxConstants.STYLE_ENDARROW, mxConstants.ARROW_CLASSIC);
        edgeStyle.put(mxConstants.STYLE_STROKECOLOR, "#000000");
        edgeStyle.put(mxConstants.STYLE_FONTCOLOR, "#000000");
        edgeStyle.put(mxConstants.STYLE_NOLABEL, !graphIsLabeled);
        mxStylesheet stylesheet = new mxStylesheet();
        stylesheet.setDefaultEdgeStyle(edgeStyle);
        return stylesheet;
    }

    /**
     * Applies the stylesheet to the visualization.
     * @param stylesheet An mxStylesheet
     * @return This GraphVisualization instance.
     */
    public GraphVisualization Style(mxStylesheet stylesheet) {
        mGraphAdapter.setStylesheet(stylesheet);
        return this;
    }

    /**
     * Displays the Graph in a JFrame.
     * @return This GraphVisualization.
     */
    public GraphVisualization Display() {
        JFrame frame = new JFrame(this.mDisplayTitle);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new mxGraphComponent(mGraphAdapter));
        frame.pack();

        frame.setLocationByPlatform(true);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(javax.swing.JFrame.DISPOSE_ON_CLOSE);
        return this;
    }

    /**
     * Displays the Graph in a JFrame.
     * @return This GraphVisualization.
     */
    public GraphVisualization Display(String windowTitle) {
        this.mDisplayTitle = windowTitle;
        return Display();
    }

    public GraphVisualization DisplayFX(String windowTitle) {
        this.mDisplayTitle = windowTitle;
        BufferedImage bufferedImage = this.BufferedImage();
        Image imageToDisplay = SwingFXUtils.toFXImage(bufferedImage, null);
        ImageView view = new ImageView(imageToDisplay);
        view.setPreserveRatio(true);

        double width = imageToDisplay.getWidth();
        double height = imageToDisplay.getHeight();

        SwingUtilities.invokeLater(() -> {
            new JFXPanel();
            Platform.runLater(() -> {
                Stage stage = new Stage();
                Group group = new Group(view);
                Scene scene = new Scene(group, width, height);
                stage.setScene(scene);
                stage.show();
            });
        });

        return this;
    }

    /**
     * Creates a BufferedImage of the graph.
     * @return A BufferedImage.
     */
    public BufferedImage BufferedImage() {
        return mxCellRenderer.createBufferedImage(this.mGraphAdapter, null, 1, Color.WHITE, true, null);
    }

    /**
     * Saves a visualization of this graph as an image file.
     * @param path The path to save this file.
     * @return This GraphVisualization.
     */
    public GraphVisualization Save(String path) {
        try {
            ImageIO.write(BufferedImage(), imageFileFormat, new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this;
    }

    public static String getImageFileFormat() {
        return imageFileFormat;
    }

    public static void setImageFileFormat(String imageFileFormat) {
        GraphVisualization.imageFileFormat = imageFileFormat;
    }

    public static boolean isGraphIsSelectable() {
        return graphIsSelectable;
    }

    public static void setGraphIsSelectable(boolean graphIsSelectable) {
        GraphVisualization.graphIsSelectable = graphIsSelectable;
    }

    public static boolean isGraphIsLabeled() {
        return graphIsLabeled;
    }

    public static void setGraphIsLabeled(boolean graphIsLabeled) {
        GraphVisualization.graphIsLabeled = graphIsLabeled;
    }

    public static int getNodeDistance() {
        return nodeDistance;
    }

    public static void setNodeDistance(int nodeDistance) {
        GraphVisualization.nodeDistance = nodeDistance;
    }

    public static int getLevelDistance() {
        return levelDistance;
    }

    public static void setLevelDistance(int levelDistance) {
        GraphVisualization.levelDistance = levelDistance;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
