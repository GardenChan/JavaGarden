package dream.high_frequency;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/7 17:13
 * author: Jiading chen
 * description: NC111 最大数
 * 给定一个nums数组由一些非负整数组成，现需要将他们进行排列并拼接，每个数不可拆分，
 * 使得最后的结果最大，返回值需要是string类型，否则可能会溢出
 */
public class MaxNumber {
    /**
     * 最大数
     * @param nums int整型一维数组
     * @return string字符串
     */
    public String solve (int[] nums) {
        // write code here
        ArrayList<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if (list.get(0).equals("0")) return "0";
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            res.append(list.get(i));
        }
        return res.toString();
    }

    public static void main(String[] args) {
        MaxNumber maxNumber = new MaxNumber();
        String solve = maxNumber.solve(new int[]{2, 20, 23, 4, 8});
        System.out.println(solve);
    }
}
