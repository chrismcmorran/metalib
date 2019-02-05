package datastructures;

import com.github.davidmoten.rtree.RTree;
import com.google.common.collect.Maps;
import org.ejml.data.Matrix;
import org.ejml.simple.SimpleMatrix;

import java.util.HashMap;

public class DataStructure<K, V> {
    public DataStructure() {

    }


    /**
     * Creates a new Simple Matrix.
     * @param data A 2D array of doubles.
     * @return SimpleMatrix
     */
    public SimpleMatrix SimpleMatrix(double[][] data) {
        return new SimpleMatrix(data);
    }

    /**
     * Creates a new Guava Hash Map.
     * @return Maps.HashMap<K, V>
     */
    public HashMap<K, V> GuavaHashMap() {
        return Maps.newHashMap();
    }
}
