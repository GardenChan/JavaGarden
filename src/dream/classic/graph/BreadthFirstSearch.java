package dream.classic.graph;

import dream.common.Graph;

import java.util.Queue;

/**
 * projectName:java-garden
 * see:dream.classic.graph_search
 * createTime:2021/10/20 20:50
 * author: Jiading chen
 * description: 图的广度优先搜索
 */
public class BreadthFirstSearch {
    private boolean[] marked;
    private int count;
    private Queue<Integer> waitSearch;

    // 初始化
    private void bfs(Graph G, int v){
        marked[v] = true;
        waitSearch.offer(v);
        while (!waitSearch.isEmpty()) {
            Integer wait = waitSearch.poll();
            for (Integer w : G.adj(wait)) {
                if (!marked[w]) {
                    bfs(G, w);
                }
            }
        }
        count++;
    }
}
