package lesson3.task2;

public class Main {

    public static void main(String[] args) {
        System.out.println("Начал работу main");
        first();
        System.out.println("Закончил работу main");
    }

    public static void first() {
        System.out.println("Начал работу first");
        second();
        third();
        System.out.println("Закончил работу first");
    }

    public static void second() {
        System.out.println("Начал работу second");
        System.out.println("Закончил работу second");
    }

    public static void third() {
        System.out.println("Начал работу third");
        fourth();
        System.out.println("Закончил работу third");
    }

    public static void fourth() {
        System.out.println("Начал работу fourth");
        System.out.println("Закончил работу fourth");
    }
}