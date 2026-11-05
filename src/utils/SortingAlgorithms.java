/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import java.util.List;
import java.util.Comparator;
import java.util.ArrayList;
/**
 *
 * @author ghest
 */
public class SortingAlgorithms {
    
    public static <T> void bubbleSort(
            List<T> list, Comparator<T> c) {

        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {

                if (c.compare(list.get(j), list.get(j + 1)) > 0) {
                    T temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    public static <T> void selectionSort(
            List<T> list, Comparator<T> c) {

        for (int i = 0; i < list.size(); i++) {
            int min = i;

            for (int j = i + 1; j < list.size(); j++) {
                if (c.compare(list.get(j), list.get(min)) < 0) {
                    min = j;
                }
            }

            T temp = list.get(i);
            list.set(i, list.get(min));
            list.set(min, temp);
        }
    }

    public static <T> void insertionSort(
            List<T> list, Comparator<T> c) {

        for (int i = 1; i < list.size(); i++) {
            T key = list.get(i);
            int j = i - 1;

            while (j >= 0 && c.compare(list.get(j), key) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }

            list.set(j + 1, key);
        }
    }

    public static <T> void mergeSort(
            List<T> list, Comparator<T> c) {

        if (list.size() <= 1) return;

        int mid = list.size() / 2;

        List<T> left = new ArrayList<>(list.subList(0, mid));
        List<T> right = new ArrayList<>(list.subList(mid, list.size()));

        mergeSort(left, c);
        mergeSort(right, c);

        int i = 0, j = 0, k = 0;

        while (i < left.size() && j < right.size()) {
            if (c.compare(left.get(i), right.get(j)) <= 0) {
                list.set(k++, left.get(i++));
            } else {
                list.set(k++, right.get(j++));
            }
        }

        while (i < left.size()) list.set(k++, left.get(i++));
        while (j < right.size()) list.set(k++, right.get(j++));
    }

    public static <T> void quickSort(
            List<T> list, Comparator<T> c) {

        quickSort(list, 0, list.size() - 1, c);
    }

    private static <T> void quickSort(
            List<T> list, int low, int high, Comparator<T> c) {

        if (low >= high) return;

        T pivot = list.get(high);
        int i = low;

        for (int j = low; j < high; j++) {
            if (c.compare(list.get(j), pivot) <= 0) {
                T temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
                i++;
            }
        }

        T temp = list.get(i);
        list.set(i, list.get(high));
        list.set(high, temp);

        quickSort(list, low, i - 1, c);
        quickSort(list, i + 1, high, c);
    }

    public static <T> void heapSort(
            List<T> list, Comparator<T> c) {

        int n = list.size();

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(list, n, i, c);
        }

        for (int i = n - 1; i > 0; i--) {
            T temp = list.get(0);
            list.set(0, list.get(i));
            list.set(i, temp);

            heapify(list, i, 0, c);
        }
    }

    private static <T> void heapify(
            List<T> list, int n, int i, Comparator<T> c) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && c.compare(list.get(left),
                list.get(largest)) > 0) {
            largest = left;
        }

        if (right < n && c.compare(list.get(right),
                list.get(largest)) > 0) {
            largest = right;
        }

        if (largest != i) {
            T temp = list.get(i);
            list.set(i, list.get(largest));
            list.set(largest, temp);

            heapify(list, n, largest, c);
        }
    }

    public static <T> void shellSort(
            List<T> list, Comparator<T> c) {

        int n = list.size();

        for (int gap = n / 2; gap > 0; gap /= 2) {

            for (int i = gap; i < n; i++) {
                T temp = list.get(i);
                int j = i;

                while (j >= gap &&
                        c.compare(list.get(j - gap), temp) > 0) {

                    list.set(j, list.get(j - gap));
                    j -= gap;
                }

                list.set(j, temp);
            }
        }
    }

    // Counting Sort for non-negative integer values
    public static void countingSort(int[] arr) {

        if (arr.length == 0) return;

        int max = arr[0];

        for (int value : arr) {
            if (value < 0) {
                throw new IllegalArgumentException(
                        "Counting Sort requires non-negative values.");
            }
            max = Math.max(max, value);
        }

        int[] count = new int[max + 1];

        for (int value : arr) {
            count[value]++;
        }

        int index = 0;

        for (int i = 0; i < count.length; i++) {
            while (count[i]-- > 0) {
                arr[index++] = i;
            }
        }
    }
    
}
