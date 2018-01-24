package pcpartclasses;

import java.io.Serializable;

public class Touple<T, U> implements Serializable {



    private final T first;
    private final U second;

    public Touple(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getX() { return first; }
    public U getY() { return second; }

}
