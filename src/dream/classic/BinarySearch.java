package dream.classic;

/**
 * projectName:java-garden
 * see:dream.classic
 * createTime:2021/10/23 21:53
 * author: Jiading chen
 * description: 二分查找
 */
public class BinarySearch {
    public static int binarySearch(int[] array, int a) {
        int low = 0;
        int high = array.length - 1;
        int mid;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            if (array[mid] == a) {
                return mid;
            } else if (a > array[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
