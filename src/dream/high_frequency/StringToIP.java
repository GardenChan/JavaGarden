package dream.high_frequency;

import java.util.ArrayList;

/**
 * projectName:java-garden
 * see:dream
 * createTime:2021/9/8 20:30
 * author: Jiading chen
 * description: NC20 数字字符串转化成IP地址
 */
public class StringToIP {
    /**
     *
     * @param s string字符串
     * @return string字符串ArrayList
     */
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        if(s.length() == 0)
            return res;
        //表示当前字符串s，可以从第0个位置开始插入'.' ，还有3个'.'可以插入
        backTrack(s, 0, 3);
        return res;
    }


    public void backTrack(String s, int start, int cnt){
        if(cnt == 0){
            String[] splits = s.split("\\.");
            //没有插入4个合法的小数点
            if(splits.length < 4)
                return;
            //判断每一位是否合法
            for(String str:splits){
                if(str.length() > 1 && str.charAt(0) == '0') return;  //最前面的数字不能为0
                if(Integer.valueOf(str) > 255) return;  //每一位都不能大于255
            }
            res.add(s);
            return;
        }

        if(start >= s.length()) return;  //没有插完全部的点 就已经超出字符串的范围了
        int len = s.length();
        //每次将一个字符作为一位
        backTrack(s.substring(0,start+1)+'.'+s.substring(start+1,len), start+2, cnt-1);
        //每次将两位字符作为一位
        if(start < len-2)
            backTrack(s.substring(0,start+2)+'.'+s.substring(start+2,len), start+3, cnt-1);
        //每次将三位字符作为一位
        if(start < len-3)
            backTrack(s.substring(0,start+3)+'.'+s.substring(start+3,len), start+4, cnt-1);
    }
}
