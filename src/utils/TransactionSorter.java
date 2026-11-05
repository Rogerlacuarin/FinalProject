/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;
import Model.Transaction;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author ghest
 */
public class TransactionSorter {
    
    public static void sort(List<Transaction> list,
            String algorithm, String column) {

        Comparator<Transaction> comparator;

        switch (column) {
            case "Name":
                comparator = Comparator.comparing(
                        Transaction::getName,
                        String.CASE_INSENSITIVE_ORDER);
                break;

            case "Date":
                comparator = Comparator.comparing(
                        Transaction::getDate);
                break;

            case "Type":
                comparator = Comparator.comparing(
                        Transaction::getType,
                        String.CASE_INSENSITIVE_ORDER);
                break;

            case "Amount":
                comparator = Comparator.comparingDouble(
                        Transaction::getAmount);
                break;

            case "Description":
                comparator = Comparator.comparing(
                        Transaction::getDescription,
                        String.CASE_INSENSITIVE_ORDER);
                break;

            default:
                return;
        }

        switch (algorithm) {
            case "Bubble Sort":
                SortingAlgorithms.bubbleSort(list, comparator);
                break;

            case "Selection Sort":
                SortingAlgorithms.selectionSort(list, comparator);
                break;

            case "Insertion Sort":
                SortingAlgorithms.insertionSort(list, comparator);
                break;

            case "Merge Sort":
                SortingAlgorithms.mergeSort(list, comparator);
                break;

            case "Quick Sort":
                SortingAlgorithms.quickSort(list, comparator);
                break;

            case "Heap Sort":
                SortingAlgorithms.heapSort(list, comparator);
                break;

            case "Shell Sort":
                SortingAlgorithms.shellSort(list, comparator);
                break;
        }
    }
    
}
