package dream.high_frequency;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/25 0:56
 * author: Garden Chan
 * description: NC82 滑动窗口的最大值
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> res = new ArrayList<>();
        if (num.length<size || size==0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < size; i++) {
            pq.offer(new int[]{num[i], i});
        }
        res.add(pq.peek()[0]);
        for (int i = size; i <= num.length - 1; i++) {
            pq.offer(new int[]{num[i], i});
            while (pq.peek()[1]<=i-size){
                pq.poll();
            }
            res.add(pq.peek()[0]);
        }
        return res;
    }
}
