package jdkreplacement;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.image.ColorModel;
import java.awt.image.IndexColorModel;
import java.awt.image.WritableRaster;
import java.util.Hashtable;

public class BufferedImage extends java.awt.image.BufferedImage {
    public BufferedImage(int width, int height, int imageType) {
        super(width, height, imageType);
    }

    public BufferedImage(int width, int height, int imageType, IndexColorModel cm) {
        super(width, height, imageType, cm);
    }

    public BufferedImage(ColorModel cm, WritableRaster raster, boolean isRasterPremultiplied, Hashtable<?, ?> properties) {
        super(cm, raster, isRasterPremultiplied, properties);
    }

    public Image GetJavaFXImage() {
        return SwingFXUtils.toFXImage(this, null);
    }
}
