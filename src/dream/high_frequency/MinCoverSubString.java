package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 21:31
 * author: Jiading chen
 * description: NC28 最小覆盖子串
 * 给出两个字符串 S 和 T，要求在O(n)的时间复杂度内在 S 中找出最短的包含 T 中所有字符的子串。
 */
public class MinCoverSubString {
    /**
     *
     * @param S string字符串
     * @param T string字符串
     * @return string字符串
     */
    /**
     *
     * @param s string字符串
     * @param t string字符串
     * @return string字符串
     */
    public String minWindow (String s, String t) {
        // write code here
        if (s == null || s == "" || t == null || t == "" || s.length() < t.length()) {
            return "";
        }
        //用来统计t中每个字符出现次数
        int[] needs = new int[128];
        //用来统计滑动窗口中每个字符出现次数
        int[] window = new int[128];

        for (int i = 0; i < t.length(); i++) {
            needs[t.charAt(i)]++;
        }

        int left = 0;
        int right = 0;

        String res = "";

        //目前有多少个字符
        int count = 0;

        //用来记录最短需要多少个字符。
        int minLength = s.length() + 1;

        while (right < s.length()) {
            char ch = s.charAt(right);
            window[ch]++;
            if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                count++;
            }

            //移动到不满足条件为止
            while (count == t.length()) {
                ch = s.charAt(left);
                if (needs[ch] > 0 && needs[ch] >= window[ch]) {
                    count--;
                }
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    res = s.substring(left, right + 1);

                }
                window[ch]--;
                left++;

            }
            right++;

        }
        return res;
    }
}
