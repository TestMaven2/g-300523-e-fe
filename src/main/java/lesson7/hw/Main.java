package lesson7.hw;

public class Main {

    public static void main(String[] args) {

        SpecialStack stack = new SpecialStack();

        stack.push(50);
        stack.push(40);
        stack.push(45);
        stack.push(35);
        stack.push(35);
        stack.push(55);
        stack.push(65);

        System.out.println(stack);
        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.getMin());

        stack.pop();

        System.out.println(stack);
        System.out.println(stack.getMin());
    }
}