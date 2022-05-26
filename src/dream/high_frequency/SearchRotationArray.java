package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/10/11 14:38
 * author: Jiading chen
 * description: LeetCode 33. 搜索旋转排序数组
 */
public class SearchRotationArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int res = -1;
        int left = 0;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                res = mid;
                break;
            }
            // 右半部分是完全有序的
            if (nums[mid] < nums[left]) {
                if (nums[mid] < target && target <= nums[right - 1]) {
                    // 在右半
                    left = mid + 1;
                } else {
                    // 在左半
                    right = mid;
                }
            } else {
                // 左半部分是完全有序的
                if (nums[mid] > target && target >= nums[left]) {
                    // 在左半
                    right = mid;
                } else {
                    // 在右半
                    left = mid + 1;
                }
            }
        }
        return res;
    }
}
