package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 10:20
 * author: Garden Chan
 * description: NC134 股票(无限次交易)
 */
public class StockMaxProfit_II {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算最大收益
     * @param prices int整型一维数组 股票每一天的价格
     * @return int整型
     */
    public int maxProfit (int[] prices) {
        // write code here
        int profit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i+1]>prices[i]){
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}
