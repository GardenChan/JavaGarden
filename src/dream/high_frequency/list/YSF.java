package dream.high_frequency.list;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.bytedance.list
 * createTime:2021/9/7 17:07
 * author: Jiading chen
 * description: NC132 环形链表的约瑟夫问题
 */
public class YSF {
    /**
     *
     * @param n int整型
     * @param m int整型
     * @return int整型
     */
    public int ysf (int n, int m) {
        // write code here
        List<Integer> children = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            children.add(i);
        }
        int index = 0;
        while (children.size()>1){
            index = (index + m - 1) % children.size();
            children.remove(index);
        }
        return children.get(0);
    }
}
