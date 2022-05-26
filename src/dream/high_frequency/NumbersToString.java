package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 21:15
 * author: Jiading chen
 * description: NC116 把数字翻译成字符串
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 */
// TODO: 2021/10/11
public class NumbersToString {
    /**
     * 解码
     * @param nums string字符串 数字串
     * @return int整型
     */
    // dp[i] 表示字符串nums中以i个位置结尾的前缀字符串的解码种数
    public int solve (String nums) {
        // write code here
        if(nums.length() == 0 || nums.charAt(0) == '0')
            return 0;
        int[] dp = new int[nums.length()];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++){
            if(nums.charAt(i) != '0'){
                dp[i] = dp[i-1];
            }
            //  3 2 4
            int num = (nums.charAt(i-1)-'0')*10 + (nums.charAt(i)-'0');
            if(num >= 10 && num <= 26){
                if(i == 1){
                    dp[i] += 1;
                }else{
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[nums.length()-1];
    }
}
