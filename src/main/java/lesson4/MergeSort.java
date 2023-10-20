package lesson4;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {

    public static void main(String[] args) {

        int[] array = new int[30];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(30);
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));

        mergeSort(array);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {

        if (array.length == 1) {
            return;
        }

        int leftLength = array.length / 2;
        int rightLength = array.length - leftLength;
        int[] leftPart = new int[leftLength];
        int[] rightPart = new int[rightLength];

        System.arraycopy(array, 0, leftPart, 0, leftLength);
        System.arraycopy(array, leftLength, rightPart, 0, rightLength);

        mergeSort(leftPart);
        mergeSort(rightPart);

        int leftIndex = 0;
        int rightIndex = 0;
        int mainIndex = 0;

        while (leftIndex < leftPart.length && rightIndex < rightPart.length) {
            if (leftPart[leftIndex] < rightPart[rightIndex]) {
                array[mainIndex++] = leftPart[leftIndex++];
            } else {
                array[mainIndex++] = rightPart[rightIndex++];
            }
        }

        while (leftIndex < leftPart.length) {
            array[mainIndex++] = leftPart[leftIndex++];
        }

        while (rightIndex < rightPart.length) {
            array[mainIndex++] = rightPart[rightIndex++];
        }
    }
}