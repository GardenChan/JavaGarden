package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.high_frequency
 * createTime:2021/11/10 2:25
 * author: Garden Chan
 * description: LeetCode 518. 零钱兑换 II
 */

/*给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

        请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。

        假设每一种面额的硬币有无限个。 

        题目数据保证结果符合 32 位带符号整数。*/

public class Change {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}