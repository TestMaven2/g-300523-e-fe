package lesson7.queue;

public class MyQueue {

    private String[] queue = new String[7];
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public int size() {
        return size;
    }

    public boolean empty() {
        return size == 0;
    }

    public void push(String data) {
        if (tail == queue.length - 1) {
            System.out.println("Очередь переполнена!");
            return;
        }
        if (!empty()) {
            tail++;
        }
        queue[tail] = data;
        size++;
    }

    public String pop() {
        if (size == 0) {
            System.out.println("Очередь пуста!");
            return null;
        }
        String data = queue[head];
        queue[head++] = null;
        size--;
        if (size == 0) {
            head = 0;
            tail = 0;
        }
        return data;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        for (int i = head; i <= tail; i++) {
            builder.append(queue[i]).append(", ");
        }
        builder.setLength(builder.length() - 2);
        builder.append("]");
        return builder.toString();
    }
}