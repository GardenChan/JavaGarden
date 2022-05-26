package dream.high_frequency;

import java.util.*;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 15:13
 * author: Jiading chen
 * description: NC147 主持人调度
 */
//@TODO 14/15
public class Host {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算成功举办活动需要多少名主持人
     * @param n int整型 有n个活动
     * @param startEnd int整型二维数组 startEnd[i][0]用于表示第i个活动的开始时间，startEnd[i][1]表示第i个活动的结束时间
     * @return int整型
     */
    public int minmumNumberOfHost (int n, int[][] startEnd) {
        if (n<=1) return n;
        // 首先按照开始时间排序，开始时间相等的按照截至时间排序
        Arrays.sort(startEnd,(o1,o2)->{
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });
        // 保存每一个时间段的终止时间，从小到大
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            // 若当前时间段的开始时间大于了队首的终止时间，那么队首的主持人可以继续主持这个，不用加人
            if (!pq.isEmpty() && pq.peek() <= startEnd[i][0]) {
                pq.poll();
            }
            pq.offer(startEnd[i][1]);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] input = {
                {2147483646,2147483647},
//                {2147483646,2147483647},
//                {2147483646,2147483647},
//                {2147483646,2147483647},
//                {2147483646,2147483647},
//                {-2147483648,-2147483647},
//                {-2147483648,-2147483647},
//                {-2147483648,-2147483647},
//                {-2147483648,-2147483647},
                {-2147483648,-2147483647}
        };
//        int[][] input = {
//                {547,612},{417,551},
//                {132,132},{168,446},
//                {95,747},{187,908},
//                {115,712},{15,329},
//                {612,900},{3,509},
//                {181,200},{562,787},
//                {136,268},{36,784},
//                {533,573},{165,946},
//                {343,442},{127,725},
//                {557,991},{604,613},
//                {633,721},{287,847},
//                {414,480},{428,698},
//                {437,616},{475,932},
//                {652,886},{19,992},
//                {132,543},{390,869},
//                {754,903},{284,925},
//                {511,951},{272,739}};
        int n = 10;
        Host host = new Host();
        int i = host.minmumNumberOfHost(n, input);
        System.out.println(i);
    }
}
