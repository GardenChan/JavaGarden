package dream.classic.graph;

import dream.common.Graph;

/**
 * projectName:java-garden
 * see:dream.classic.graph_search
 * createTime:2021/10/20 20:44
 * author: Jiading chen
 * description: 图的深度优先搜索
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int s){
        this.marked = new boolean[G.V()];
        dfs(G, s);
    }

    private void dfs(Graph G, int s) {
        marked[s] = true;
        for (Integer w : G.adj(s)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        count++;
    }
}
