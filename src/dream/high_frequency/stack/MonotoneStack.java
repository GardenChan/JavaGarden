package dream.high_frequency.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 11:42
 * author: Jiading chen
 * description: NC157 单调栈
 */
public class MonotoneStack {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param nums int一维数组
     * @return int二维数组
     */
    public int[][] foundMonotoneStack (int[] nums) {
        // write code here
        int len = nums.length;
        int[][] res = new int[len][2];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i][0] = -1;
            }else {
                res[i][0] = stack.peek();
            }
            stack.push(i);
        }

        stack.clear();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                res[i][1] = -1;
            }else {
                res[i][1] = stack.peek();
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {1,1,1,1,1,1,1};
        MonotoneStack monotoneStack = new MonotoneStack();
        int[][] ints = monotoneStack.foundMonotoneStack(input);
        System.out.println(Arrays.deepToString(ints));
    }
}

