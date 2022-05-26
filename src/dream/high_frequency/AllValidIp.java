package dream.high_frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.high_frequency
 * createTime:2021/11/11 18:29
 * author: Garden Chan
 * description: 剑指 Offer II 087. 复原 IP
 */
public class AllValidIp {
    List<String> res = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        dfsRestoreIpAddresses(new StringBuilder(s), 0, 0);
        return res;
    }

    boolean isValid(String s) {
        return !s.isEmpty() && s.length() < 4 && (s.length() <= 1 || s.charAt(0) != '0') && Integer.parseInt(s) <= 255;
    }

    void dfsRestoreIpAddresses(StringBuilder s, int startIndex, int nodeCount) {
        if (nodeCount == 3) {
            if(isValid(s.substring(startIndex))) {
                res.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length() && i < startIndex + 3; i++) {
            String subIp = s.substring(startIndex, i + 1);
            if(isValid(subIp)) {
                s.insert(i + 1, ".");
                dfsRestoreIpAddresses(s, i + 2, nodeCount + 1);
                s.deleteCharAt(i + 1);
            }
        }
    }
}
