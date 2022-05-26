package dream.high_frequency;

import java.util.PriorityQueue;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 16:11
 * author: Jiading chen
 * description: NC159 最小生成树
 * 一个有 n 户人家的村庄，有 m 条路相互连接着。
 * 村里现在要修路，每条路都有一个成本价格，
 * 现在请你帮忙计算下，最少需要花费多少钱，就能让这 n 户人家连接起来。
 *
 * cost为一个二维数组，
 * 每个元素是一个长度为 3 的一维数组 a， a[0] 和 a[1] 表示村庄 a[0]和村庄 a[1]有一条路，
 * 修这条路的成本价格为 a[2].
 */
//@TODO
public class MiniSpanningTree {
    public int miniSpanningTree (int n, int m, int[][] cost) {
        // write code here
        int[] father = new int[n+1];
        for(int i=0;i<father.length;++i){
            father[i] = i;
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((a, b)->a.cost-b.cost);
        for(int [] c: cost){
            queue.add(new Node(c[2],c[1],c[0]));
        }

        int ans = 0;
        while(!queue.isEmpty()){
            Node cur = queue.poll();
            if(find(father,cur.start) != find(father,cur.end)){
                ans += cur.cost;
                union(father,cur.start,cur.end);
            }
        }
        return ans;

    }

    static class Node{
        int cost;
        int start;
        int end;
        public Node(int c,int s , int e){
            this.start=s;
            this.end = e;
            this.cost = c;
        }
    }

    public int find(int[] f,int a){
        if(f[a] ==a){
            return a;
        }
        return f[a]=find(f,f[a]);
    }

    public void union(int[] f, int a ,int b){
        int fa = find(f,a);
        int fb = find(f,b);
        f[fa]=fb;
    }
}
