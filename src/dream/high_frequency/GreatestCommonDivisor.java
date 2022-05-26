package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 1:57
 * author: Garden Chan
 * description: NC151 最大公约数
 */
public class GreatestCommonDivisor {
    public int gcd(int m,int n){
        int max = Math.max(m, n), min = Math.min(m, n);
        if (max % min==0) {
            return min;
        }else {
            return gcd(min, max % min);
        }
    }
}
