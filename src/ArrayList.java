import java.util.Arrays;

public class ArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 2;
    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];

    public void remove(int index) {
        if (index < 0)
            index = 0;
        if (index >= size)
            index = size - 1;
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void remove() {
        remove(size);
    }

    public void add(int index, E element) {
        if (size >= elements.length) {
            expand();
        }
        if (index < 0)
            index = 0;
        if (index > size)
            index = size;
        for (int i = size; i> index; i--){
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }

    public void add(E element) {
        add(size, element);
    }

    public E get(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        return elements[i];
    }

    private void expand() {
        elements = Arrays.copyOf(elements, elements.length + DEFAULT_CAPACITY);
    }

    public int getSize() {
        return size;
    }

}
