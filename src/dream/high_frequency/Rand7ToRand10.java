package dream.high_frequency;

import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/10/11 14:25
 * author: Jiading chen
 * description:
 */
public class Rand7ToRand10 {
    private int rand7() {
        return 1 + (int) (Math.random() * 7);
    }

    public int rand10(){
        int row, col, index;
        do {
            row = rand7();
            col = rand7();
            index = col + (row - 1) * 7;
        } while (index > 40);
        return 1 + (index - 1) % 10;
    }

    public static void main(String[] args) {
        Rand7ToRand10 rand7ToRand10 = new Rand7ToRand10();
        int[] ints = new int[10];
        for (int i = 0; i < 100000; i++) {
            ints[rand7ToRand10.rand10() - 1]++;
        }
        System.out.println(Arrays.toString(ints));
    }
}
