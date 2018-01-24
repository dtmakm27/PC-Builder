package pcpartclasses;

import java.io.Serializable;

public class Triple<T, U, V> implements Serializable {

    private final T first;
    private final U second;
    private final V third;

    public Triple(T first, U second, V third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public T getX() { return first; }
    public U getY() { return second; }
    public V getZ() { return third; }
}
//Triple tri = new Triple<Integer, Integer, Integer>(5,2,3);  // initialising
//System.out.println(tri.getFirst());