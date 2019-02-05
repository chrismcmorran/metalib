package util;

public class Tuple<Left, Right> {
    private Left left;
    private Right right;

    public Tuple(Left left, Right right) {
        this.left = left;
        this.right = right;
    }

    public Tuple() {
        this.left = null;
        this.right = null;
    }

    /**
     * Returns the left item in the tuple.
     * @return Left
     */
    public Left getLeft() {
        return left;
    }

    /**
     * Returns the right item in the tuple.
     * @return Right
     */
    public Right getRight() {
        return right;
    }

    public String toString() {
        return "(" + this.left.toString() + ", " + this.right.toString() + ")";
    }
}
