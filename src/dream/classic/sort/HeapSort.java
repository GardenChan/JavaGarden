package dream.classic.sort;

import java.util.Arrays;

/**
 * projectName:Java-Garden
 * see:dream.classic
 * createTime:2021/8/1 16:48
 * author: Garden Chan
 * description: 堆排序
 */
public class HeapSort {
    public static void sort(int[] arr){
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            exchange(arr, 0, i);
            maxHeapify(arr, 0, i);
        }
    }

    private static void buildMaxHeap(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, arr.length);
        }
    }

    private static void maxHeapify(int[] arr, int i, int heapSize) {
        int l = 2 * i + 1;
        int r = l + 1;
        int largest = i;
        if (l<heapSize && arr[l] > arr[largest]){
            largest = l;
        }
        if (r<heapSize && arr[r]>arr[largest]){
            largest = r;
        }
        if (largest != i){
            exchange(arr,i,largest);
            maxHeapify(arr, largest, heapSize);
        }
    }

    private static void exchange(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        HeapSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
