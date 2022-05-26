package dream.classic.sort;

import java.util.Arrays;

/**
 * projectName:Java-Garden
 * see:dream.classic
 * createTime:2021/8/1 16:24
 * author: Garden Chan
 * description: 归并排序
 */
public class MergeSort {
    // 归并所需要的辅助数组
    private static int[] assist;

    // 对数组array进行排序
    public static void sort(int[] array){
        assist = new int[array.length];
        int low = 0;
        int high = array.length - 1;
        sort(array, low, high);
    }

    private static void sort(int[] array, int low, int high) {
        if (high<=low) return;
        int mid = low + (high - low) / 2;
        sort(array, low, mid);
        sort(array, mid + 1, high);
        merge(array, low, mid, high);
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int index = low;
        int l = low;
        int h = mid + 1;

        while (l<=mid&&h<=high){
            if (array[l]<=array[h]){
                assist[index++] = array[l++];
            }else {
                assist[index++] = array[h++];
            }
        }

        while (l<=mid){
            assist[index++] = array[l++];
        }

        while (h<=high){
            assist[index++] = array[h++];
        }

        for (int i = low; i <= high; i++) {
            array[i] = assist[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 0};
        MergeSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
