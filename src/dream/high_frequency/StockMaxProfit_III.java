package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 16:45
 * author: Jiading chen
 * description: NC135 股票交易的最大收益（二） 限制最多两次交易
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/solution/wu-chong-shi-xian-xiang-xi-tu-jie-123mai-mai-gu-pi/
 */
// @TODO
public class StockMaxProfit_III {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) {
            return 0;
        }
        int n = prices.length;
        //定义5种状态，并初始化第一天的状态
        int dp0 = 0;
        int dp1 = -prices[0];
        int dp2 = 0;
        int dp3 = -prices[0];
        int dp4 = 0;
        for(int i=1;i<n;++i) {
            //这里省略dp0，因为dp0每次都是从上一个dp0来的相当于每次都是0
            //处理第一次买入、第一次卖出
            dp1 = Math.max(dp1,dp0-prices[i]);
            dp2 = Math.max(dp2,dp1+prices[i]);
            //处理第二次买入、第二次卖出
            dp3 = Math.max(dp3,dp2-prices[i]);
            dp4 = Math.max(dp4,dp3+prices[i]);
        }
        //返回最大值
        return Math.max(0,Math.max(Math.max(dp1,dp2),Math.max(dp3,dp4)));
    }
}
