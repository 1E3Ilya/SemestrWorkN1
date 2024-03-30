import java.util.Arrays;

import java.util.Arrays;

public class Introsort {
    private static final int INSERTION_SORT_THRESHOLD = 16;
    private static final int MAX_DEPTH = 2 * (int) Math.floor(Math.log(Integer.MAX_VALUE));
    public static int count = 0;

    public static void sort(int[] arr) {
        count = 0;
        sort(arr, 0, arr.length - 1, MAX_DEPTH);
    }

    private static void sort(int[] arr, int low, int high, int maxDepth) {
        if (high - low < INSERTION_SORT_THRESHOLD) {
            insertionSort(arr, low, high);
            return;
        }
        if (maxDepth == 0) {
            heapSort(arr, low, high);
            return;
        }
        int pivot = partition(arr, low, high);
        sort(arr, low, pivot - 1, maxDepth - 1);
        sort(arr, pivot + 1, high, maxDepth - 1);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            count++;
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private static void insertionSort(int[] arr, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= low && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
                count++;
            }
            arr[j + 1] = key;
        }
    }

    private static void heapSort(int[] arr, int low, int high) {
        int n = high - low + 1;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, low, high, i);
        }
        for (int i = high; i > low; i--) {
            swap(arr, low, i);
            heapify(arr, low, i - 1, 0);
        }
    }

    private static void heapify(int[] arr, int low, int high, int root) {
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left <= high && arr[left] > arr[largest]) {
            largest = left;
        }
        if (right <= high && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, low, high, largest);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}


