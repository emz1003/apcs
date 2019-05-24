import java.util.Iterator;

public interface List<E> {
    int size();
    boolean isEmpty();
    boolean add(E value);// add to end
    void add(int i, E value); // insert at index i
    E remove(int i); // removes object at index i
    E get(int i);
    E set(int i, E newValue); // returns the old value
    Iterator<E> iterator();
}