package lesson3.task1;

public class Main {

    public static void main(String[] args) {
        System.out.println("Создаём коробки итеративно:");
        createBox(5);
        System.out.println();
//        System.out.println("Создаём коробки рекурсивно:");
//        createBoxWithRecursion(5);
    }

    public static void createBox(int size) {
        // Итеративный подход
        for (int i = size; i > 0; i--) {
            System.out.println("Создана коробка размером - " + i);
        }
    }

    public static void createBoxWithRecursion(int size) {
        // Рекурсивный подход
        if (size == 0) { // Базовый случай
            return;
        }
        System.out.println("Создана коробка размером - " + size);
        createBoxWithRecursion(size - 1); // Рекурсивный случай
    }
}