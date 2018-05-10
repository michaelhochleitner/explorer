package sample;

public class Tuple<X, Y> {
    public final X x;
    public final Y y;
    public Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public boolean equals(Object o) {

        if (o == this) return true;
        if (!(o instanceof Tuple)) {
            return false;
        }

        Tuple tuple = (Tuple) o;

        return tuple.x == x && tuple.y == y;
    }
}