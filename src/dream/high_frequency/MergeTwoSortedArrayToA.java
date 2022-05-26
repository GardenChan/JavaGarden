package dream.high_frequency;

import java.util.Arrays;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/9 1:54
 * author: Garden Chan
 * description: NC22 合并两个有序的数组
 */
public class MergeTwoSortedArrayToA {
    public void merge(int A[], int m, int B[], int n) {
        int BFlag = n - 1;
        int AFlag = m - 1;
        int index = m + n - 1;
        while (BFlag >= 0 && AFlag >= 0) {
            if (B[BFlag] >= A[AFlag]) {
                A[index--] = B[BFlag--];
            } else {
                A[index--] = A[AFlag--];
            }
        }
        while (BFlag>=0){
            A[index--] = B[BFlag--];
        }
        while (AFlag>=0){
            A[index--] = A[AFlag--];
        }
    }

    public static void main(String[] args) {
        MergeTwoSortedArrayToA arrayToA = new MergeTwoSortedArrayToA();
        int[] A = {4,5,6,0,0,0};
        int[] B = {1,2,3};
        arrayToA.merge(A, 3, B, 3);
        System.out.println(Arrays.toString(A));
    }
}
