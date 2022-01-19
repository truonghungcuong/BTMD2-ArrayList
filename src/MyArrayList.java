import java.util.Arrays;

public class MyArrayList<E> {

    private final int DEFAULT_CAPACITY = 10;
    private E[] elements = (E[]) new Object[DEFAULT_CAPACITY];
    private int size = 0;

    public MyArrayList() {
    }

    public MyArrayList(int size) {
        this.size = size;
    }

    public void set(int index, E element) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("index " + index + " of size " + size);
        } else {
            elements[index] = element;
        }

    }

    public int indexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public int lastIndexOf(E element) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                index = i;
            }
        }
        return index;
    }

    public void remove(int index) {
        if (index < 0 || index > size)
            return;
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void replace(E oldElement, E newElement) {
        int index = indexOf(oldElement);
        if (index > -1) {
            elements[index] = newElement;
        }
    }

    public void replaceAll(E oldElement, E newElement) {
        // slow way
        if (oldElement.equals(newElement)) return;
        int index = -1;
        do {
            index = indexOf(oldElement);
            if (index > -1)
                elements[index] = newElement;
        } while (index != -1);
    }

    public void remove(E element) {
        remove(indexOf(element));
    }

    public void removeAll(E element) {
        // slow way
        int index = -1;
        do {
            index = indexOf(element);
            if (index > -1)
                remove(index);
        } while (index != -1);
    }

    public void clear(){
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }
    public E[] toArray(){
        return Arrays.copyOf(elements, size);
    }
    public void trimToSize(int newSize){
        if (newSize < 0 || newSize > size){
            throw new ArrayIndexOutOfBoundsException("invalid new size");
        } else {
            size = newSize;
            elements = Arrays.copyOf(elements, size);
        }

    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void removeFirst() {
        remove(0);
    }

    public void removeLast() {
        size--;
    }

    public void addFirst(E element) {
        add(0, element);
    }

    public void addLast(E element) {
        add(size, element);
    }

    public void add(E element) {
        if (size >= elements.length)
            expand();
        elements[size] = element;
        size++;
    }

    public void add(int index, E element) {
        if (index < 0)
            index = 0;
        if (index > size)
            index = size;
        if (size >= elements.length)
            expand();
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    protected void expand() {
        elements = Arrays.copyOf(elements, size + DEFAULT_CAPACITY);
    }


    public E get(int index) {
        if (index < 0 || index > size)
            return null;
        return elements[index];
    }

    public int size() {
        return size;
    }

}