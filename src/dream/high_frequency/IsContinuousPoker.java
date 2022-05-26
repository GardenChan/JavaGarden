package dream.high_frequency;

import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 11:09
 * author: Garden Chan
 * description: NC63 扑克牌顺子
 */
public class IsContinuousPoker {
    public boolean IsContinuous(int [] numbers) {
        int joker = 0;
        Arrays.sort(numbers);
        for (int number : numbers) {
            if (number == 0) {
                joker++;
            }
        }
        if (joker>=numbers.length-1) return true;
        for (int i = joker; i < numbers.length-1; i++) {
            if (numbers[i + 1] == numbers[i]) {
                return false;
            }else {
                joker -= numbers[i + 1] - numbers[i] - 1;
            }
        }
        return joker >= 0;
    }

    public static void main(String[] args) {
        int[] input = {0, 3, 2, 6, 4};
        IsContinuousPoker isContinuousPoker = new IsContinuousPoker();
        boolean b = isContinuousPoker.IsContinuous(input);
        System.out.println(b);
    }
}
