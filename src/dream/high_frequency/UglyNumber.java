package dream.high_frequency;

import java.util.ArrayList;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 10:20
 * author: Jiading chen
 * description: NC79 丑数
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    public int getKthUglyNumber(int K) {
        if (K==1) return 1;
        int num = 1;
        int count = 1;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        while (true){
            if (count==K){
                return list.get(count - 1);
            }
            num++;
            if (isUgly(num)){
                list.add(num);
                count++;
            }
        }
    }

    private boolean isUgly(int num){
        if (num == 0) {
            return false;
        }
        while (num % 2 == 0) {
            num /= 2;
        }
        while (num % 3 == 0) {
            num /= 3;
        }
        while (num % 5 == 0) {
            num /= 5;
        }
        if (num == 1) {
            return true;
        }
        return false;
    }


    public int GetUglyNumber_Solution(int index) {
        if (index==0) return 0;
        // 三个变量 后面有大作用！
        int i2 = 0,i3 = 0,i5 = 0;
        int[] res = new int[index];
        res[0] = 1;  // 第一个丑数为 1

        for(int i = 1; i < index; i++){
            // 得到下一个丑数，三者中最小的
            res[i] = Math.min(res[i2]*2,Math.min(res[i3]*3,res[i5]*5));
            /*第一次是 2、3、5比较，得到最小的是2*/
            /*第二次是 4、3、5比较，为什么是4了呢？因为上次2已经乘了一次了，所以接下去可以放的丑数在4、3、5之间*/
            // 所以开头的三个指针就是来标记2 3 5 乘的次数的
            if(res[i] == res[i2]*2)
                i2++;
            if(res[i] == res[i3]*3)
                i3++;
            if(res[i] == res[i5]*5)
                i5++;
        }
        return res[index-1];
    }

    public static void main(String[] args) {
        UglyNumber uglyNumber = new UglyNumber();
        int kthUglyNumber = uglyNumber.getKthUglyNumber(7);
        System.out.println(kthUglyNumber);
    }
}
