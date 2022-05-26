package dream.high_frequency;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 0:25
 * author: Garden Chan
 * description: NC7 买卖股票的最好时机
 */
public class StockMaxProfit {
    /**
     *
     * @param prices int整型一维数组
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i]<minPrice) minPrice = prices[i];
            if (prices[i]-minPrice>maxProfit) maxProfit = prices[i] - minPrice;
        }
        return maxProfit;
    }
}
