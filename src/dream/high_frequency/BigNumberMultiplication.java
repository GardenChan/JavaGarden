package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/7 18:26
 * author: Jiading chen
 * description:
 */
public class BigNumberMultiplication {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param num1 string字符串 第一个整数
     * @param num2 string字符串 第二个整数
     * @return string字符串
     */
    public String solve (String num1, String num2) {
        // write code here
        //  不合法输入
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }
        // 如果有一个数字为 0
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        // 最后的结果
        String res = "0";
        // 相乘之后，后面需要补零的个数
        int zero = 0;
        // 从右往左遍历num2字符串中的每一个数字，使其和num1字符串相乘
        for (int i = chars2.length - 1; i >= 0; i--) {
            // 每一个数字和num1相乘的结果
            StringBuilder temp = new StringBuilder();
            // 保存进位
            int carry = 0;
            // 将后面需要的0补齐
            for (int j = 0; j < zero; j++) {
                temp.append('0');
            }
            zero++;
            // 取出num2字符串的每一个数字 记为 y
            int y = chars2[i] - '0';
            for (int j = chars1.length - 1; j >= 0; j--) {
                int x = chars1[j] - '0';
                int num = x * y + carry;
                temp.append(num % 10);
                carry = num / 10;
            }
            if (carry != 0) {
                temp.append(carry);
            }
            res = bigNumberAdd(res, temp.reverse().toString());
        }
        return res;
    }

    /**
     * @param num1 第一个数字字符串
     * @param num2 第二个数字字符串
     * @return  两个字符串相加之后的结果
     */
    public String bigNumberAdd(String num1, String num2) {
        // 判断不合法输入
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() == 0) {
            return null;
        }
        // num1 字符串的下标， 从右往左遍历
        int index1 = num1.length() - 1;
        // num2 字符串的下标， 从右往左遍历
        int index2 = num2.length() - 1;

        // 最后相加的结果
        StringBuilder res = new StringBuilder();
        // 保存进位
        int carry = 0;

        // num1 或 num2 只要有一个字符串还有值，就继续循环
        while (index1 >= 0 || index2 >= 0) {
            // 拿到 num1 的一个数字
            int x = index1 >= 0 ? num1.charAt(index1--) - '0' : 0;
            // 拿到 num2 的一个数字
            int y = index2 >= 0 ? num2.charAt(index2--) - '0' : 0;
            // 拿到的 2 个数字相加，要考虑进位的情况
            int num = x + y + carry;
            // 该位只保存个位数
            res.append(num % 10);
            // 十位数要往前进一位
            carry = num / 10;
        }
        // 如果最后进位不为 0 ， 则还需要往前进 carry 位
        if (carry != 0) {
            res.append(carry);
        }
        return res.reverse().toString();
    }
}
