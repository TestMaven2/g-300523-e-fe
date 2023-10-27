package lesson5;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {

        int[] array = new int[30];
        Random random = new Random();

        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(30);
        }

        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));

        quickSort(array, 0, array.length - 1);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int startIndex, int endIndex) {

        if (startIndex >= endIndex) {
            return;
        }

        int pivotIndex = helper(array, startIndex, endIndex);
        quickSort(array, startIndex, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, endIndex);
    }

    public static int helper(int[] array, int startIndex, int endIndex) {
        int pivotIndex = endIndex;
        int pivot = array[pivotIndex];

        for (int i = startIndex; i < pivotIndex - 1; i++) {
            if (array[i] >= pivot) {
                swap(array, pivotIndex, pivotIndex - 1);
                pivotIndex--;
                swap(array, i, pivotIndex + 1);
                i--;
            }
        }

        if (array[pivotIndex - 1] > pivot) {
            swap(array, pivotIndex, pivotIndex - 1);
            pivotIndex--;
        }

        return pivotIndex;
    }

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}