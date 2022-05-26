package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 1:35
 * author: Garden Chan
 * description: NC65 斐波那契数列
 */
public class Fibonacci {
    public int fibonacci(int n) {
        if(n==0) return 0;
        if (n==1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
