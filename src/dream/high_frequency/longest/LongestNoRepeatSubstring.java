package dream.high_frequency.longest;

import java.util.HashMap;
import java.util.Map;

/**
 * projectName:java-garden
 * see:dream.high_frequency.longest
 * createTime:2021/11/10 1:28
 * author: Garden Chan
 * description: LeetCode 3. 无重复字符的最长子串
 */
public class LongestNoRepeatSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap();
        int len = s.length(),ans = 0;         //len =字符串长度，ans为返回答案
        for( int right = 0,left = 0; right<len; right++)
        {
            if (map.containsKey(s.charAt(right))) left = Math.max(left,map.get(s.charAt(right))+1);
            //取最大值防止区间左端点回退情况
            ans = Math.max(ans,right-left+1); //区间右端点下标-区间左端点下标 +1 = 区间长度
            map.put(s.charAt(right),right); //注意，更新字符对应的下标。
        }
        return ans;
    }
}
