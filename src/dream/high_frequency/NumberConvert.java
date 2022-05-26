package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 2:35
 * author: Garden Chan
 * description: NC112 进制转换
 * 给定一个十进制数 M ，以及需要转换的进制数 N 。
 * 将十进制数 M 转化为 N 进制数。
 */
public class NumberConvert {
    /**
     * 进制转换
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public String solve (int M, int N) {
        // write code here
        if (M==0) return "0";
        String index = "0123456789ABCDEF";
        StringBuilder res = new StringBuilder();
        boolean ifNegative = false;
        if (M<0){
            M = -M;
            ifNegative = true;
        }
        while (M!=0){
            res.append(index.charAt(M % N));
            M /= N;
        }
        if (ifNegative) res.append("-");
        return res.reverse().toString();
    }
}
