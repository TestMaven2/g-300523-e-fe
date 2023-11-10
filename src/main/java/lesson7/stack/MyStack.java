package lesson7.stack;

public class MyStack {

    private String[] stack = new String[7];
    private int size = 0;

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(String data) {
        if (size == stack.length) {
            System.out.println("Стек переполнен!");
            return;
        }
        stack[size++] = data;
    }

    public String pop() {
        if (size == 0) {
            System.out.println("Стек пуст!");
            return null;
        }
        String data = stack[--size];
        stack[size] = null;
        return data;
    }

    public String peek() {
        if (size == 0) {
            System.out.println("Стек пуст!");
            return null;
        }
        return stack[size - 1];
    }

    public int search(String data) {
        for (int i = 0; i < size; i++) {
            if (stack[i].equals(data)) {
                return size - i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            builder.append(stack[i]).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }
}