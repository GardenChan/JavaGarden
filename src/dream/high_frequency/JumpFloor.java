package dream.high_frequency;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/9 0:15
 * author: Garden Chan
 * description: NC68 跳台阶
 */
public class JumpFloor {
    /**
     * f(n) = f(n-1) + f(n-2)
     * @param target 总台阶数
     * @return int 跳法
     */
    public int jumpFloor(int target) {
        if (target==1) return 1;
        if (target==2) return 2;
        return jumpFloor(target - 1) + jumpFloor(target - 2);
    }

    public static void main(String[] args) {
        JumpFloor frog = new JumpFloor();
        int i = frog.jumpFloor(7);
        System.out.println(i);
    }
}
