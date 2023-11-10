package lesson7.stack;

public class Main {

    public static void main(String[] args) {

        MyStack stack = new MyStack();

        System.out.println("Размер стека - " + stack.size());
        System.out.println("Пустой ли стек - " + stack.empty());
        System.out.println(stack);
        stack.pop();

        stack.push("AAA");
        stack.push("BBB");
        stack.push("CCC");
        stack.push("DDD");
        stack.push("EEE");
        stack.push("FFF");
        stack.push("GGG");
        stack.push("HHH");

        System.out.println("Размер стека - " + stack.size());
        System.out.println("Пустой ли стек - " + stack.empty());
        System.out.println(stack);

        String removedElement = stack.pop();
        System.out.println(stack);
        System.out.println("Удалённый элемент - " + removedElement);

        removedElement = stack.pop();
        System.out.println(stack);
        System.out.println("Удалённый элемент - " + removedElement);

        System.out.println("Размер стека - " + stack.size());

        String receivedElement = stack.peek();
        System.out.println("Полученный элемент - " + receivedElement);
        System.out.println(stack);

        System.out.println("Позиция элемента DDD - " + stack.search("DDD"));
        System.out.println("Позиция элемента BBB - " + stack.search("BBB"));
        System.out.println("Позиция элемента FFF - " + stack.search("FFF"));
    }
}