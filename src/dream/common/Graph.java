package dream.common;

import java.util.LinkedList;
import java.util.Queue;

/**
 * projectName:java-garden
 * see:dream.common
 * createTime:2021/10/20 20:27
 * author: Jiading chen
 * description: 图的表示 邻接表
 */
public class Graph {
    // 顶点数目
    private final int V;
    // 边的数量
    private int Edge;
    // 邻接表
    private Queue<Integer>[] adj;

    // 初始化图
    private Graph(int V){
        this.V = V;
        this.Edge = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<Integer>();
        }
    }

    // 添加边
    public void addEdge(int i, int j){
        adj[i].offer(j);
        adj[j].offer(i);
        Edge++;
    }

    // 获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    // 获取顶点数目
    public int V(){
        return V;
    }

    // 获取边的数目
    public int E(){
        return Edge;
    }
}
