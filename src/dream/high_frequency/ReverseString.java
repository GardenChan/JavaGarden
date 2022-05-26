package dream.high_frequency;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/19 23:56
 * author: Garden Chan
 * description: NC103 反转字符串
 */
public class ReverseString {
    public String solve (String str) {
        // write code here
        return new StringBuilder(str).reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        String solve = reverseString.solve("123456789");
        System.out.println(solve);
    }
}
