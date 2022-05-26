package dream.high_frequency.longest;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/17 23:32
 * author: Garden Chan
 * description: NC127 最长公共子串
 */
public class LongestCommonSubString {
    /**
     * longest common substring
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @return string字符串
     */
    public String LCS (String str1, String str2) {
        // write code here
        // 记录最长公共子串的长度
        int maxLength = 0;
        // 记录最长公共子串最后一个元素在字符串str1中的位置
        int maxLastIndex = 0;
        int[][] dp = new int[str1.length()+1][str2.length()+1];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)){
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    if (dp[i+1][j+1]>maxLength){
                        maxLength = dp[i + 1][j + 1];
                        maxLastIndex = i;
                    }
                }else {
                    dp[i + 1][j + 1] = 0;
                }
            }
        }
        return str1.substring(maxLastIndex - maxLength + 1, maxLastIndex + 1);
    }

    public static void main(String[] args) {
        LongestCommonSubString longestCommonSubString = new LongestCommonSubString();
        String lcs = longestCommonSubString.LCS("1AB2345CD", "12345EF");
        System.out.println(lcs);

    }
}
