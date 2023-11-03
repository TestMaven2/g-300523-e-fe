package lesson6;

public class DynamicArray {

    private String[] array;
    private int defaultSize = 10;
    private int size = 0;

    public DynamicArray() {
        array = new String[defaultSize];
    }

    public DynamicArray(int size) {
        array = new String[size];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(String data) {
        if (array.length == size) {
            growSize();
        }
        array[size++] = data;
    }

    private void growSize() {
        String[] newArray = new String[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public String remove() {
        String data = array[size - 1];
        array[size-- - 1] = null;
        return data;
    }

    public String removeAt(int index) {
        String data = array[index];
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        array[--size] = null;
        return data;
    }

    public void set(int index, String data) {
        array[index] = data;
    }

    public boolean contains(String data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public void clean() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(array[i]).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }
}