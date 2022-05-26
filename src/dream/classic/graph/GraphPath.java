package dream.classic.graph;

import dream.common.Graph;

import java.util.Stack;

/**
 * projectName:java-garden
 * see:dream.classic.graph
 * createTime:2021/10/20 21:22
 * author: Jiading chen
 * description:
 */
public class GraphPath {
    // 索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    // 起点
    private int s;
    // 索引代表顶点 值代表从起点s到当前顶点路径上s的前一顶点
    private int[] edgeTo;

    //构造深度优先搜索对象，使用深度优先搜索找出G图中起点为s的所有路径
    public GraphPath(Graph G, int s) {
        this.marked = new boolean[G.V()];
        this.edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    //使用深度优先搜索找出G图中v顶点的所有相邻顶点
    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    //判断w顶点与s顶点是否存在路径
    public boolean hasPathTo(int v){
        return marked[v];
    }

    public Stack<Integer> pathTo(int v){
        //当前v顶点与s顶点不连通，所以直接返回null，没有路径
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<>();
        for (int i = v; i != s; i = edgeTo[i]) {
            //把当前顶点放入容器
            path.push(v);
        }
        //把起点s放入容器
        path.push(s);
        return path;
    }
}
