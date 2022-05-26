package dream.classic.sort;

import java.util.Arrays;

/**
 * projectName:Java-Garden
 * see:dream.classic.sort
 * createTime:2021/8/8 23:14
 * author: Garden Chan
 * description: 快速排序
 */
public class QuickSort {
    public static void sort(int[] array){
        int low = 0;
        int high = array.length - 1;
        sort(array, low, high);
    }

    private static void sort(int[] array, int low, int high) {
        if (high<=low) return;
        // 对array数组种 从low到high的元素进行切分
        int partition = partition(array, low, high);
        // 对左边分组进行排序
        sort(array, low, partition - 1);
        sort(array, partition + 1, high);
    }

    private static int partition(int[] array, int low, int high) {
        // 把最左边的元素当作基准值
        int key = array[low];
        // 定义一个左指针
        int left = low;
        // 定义一个右侧指针
        int right = high + 1;

        // 进行切分
        while (true){
            // 从右往左
            while (key<array[--right]){
                if (right==low) break;
            }

            // 从左往右
            while (key>array[++left]){
                if (left==high) break;
            }

            if (left>=right){
                break;
            }else {
                exch(array,left,right);
            }
        }
        exch(array, low, right);
        return right;
    }

    private static void exch(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        QuickSort.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
