package dream.classic.sort;

import java.util.Arrays;

/**
 * projectName:Java-Garden
 * see:dream.classic
 * createTime:2021/8/1 11:18
 * author: Garden Chan
 * description: 各种排序算法：冒泡排序、选择排序、插入排序、希尔排序、归并排序、堆排序、快速排序
 */
public class Sort {
    // 冒泡排序
    public static void bubbleSort(int[] array){
        int temp = 0;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if (array[j]>array[j+1]){
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // 选择排序
    public static void selectionSort(int[] arr){
        int temp = 0;
        for (int i = 0; i < arr.length-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[minIndex]){
                    minIndex = j;
                }
            }
            temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    // 插入排序
    public static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int num = arr[i];
            int index = i - 1;
            while (index>=0 && arr[index]>num){
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = num;
        }
    }

    //希尔排序
    public static void shellSort(int[] arr){
        int len = arr.length;
        int h = 1;
        while (h<len/2){
            h = h * 2 + 1;
        }

        while (h>=1){
            for (int i = h; i < arr.length; i += h) {
                int num = arr[i];
                int index = i - h;
                while (index >= 0 && arr[index] > num) {
                    arr[index + h] = arr[index];
                    index = index - h;
                }
                arr[index + h] = num;
            }
            h /= 2;
        }
    }


    public static void main(String[] args) {
        int[] arr = {9,8,7,6,5,4,3,2,1,0};
//        bubbleSort(arr);
//        selectionSort(arr);
//        insertSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
