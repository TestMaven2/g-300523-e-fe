package lesson3.task3;

public class Main {

    public static void main(String[] args) {
        System.out.println(getFact(5));
    }

    public static int getFact(int value) {
        if (value == 1) {
            return 1;
        }
        return value * getFact(value - 1);
    }
}