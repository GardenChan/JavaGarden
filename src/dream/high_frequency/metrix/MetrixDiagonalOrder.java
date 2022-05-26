package dream.high_frequency.metrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.bytedance.metrix
 * createTime:2021/10/11 15:20
 * author: Jiading chen
 * description: 1424. 对角线遍历 II
 */
public class MetrixDiagonalOrder {
    class Node{
        int row;
        int col;
        int num;

        Node(int i, int j, int num) {
            this.row = i;
            this.col = j;
            this.num = num;
        }
    }
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                list.add(new Node(i, j, nums.get(i).get(j)));
            }
        }
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                int index1 = o1.row + o1.col;
                int index2 = o2.row + o2.col;
                return index1 == index2 ? o2.row - o1.row : index1 - index2;
            }
        });
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i).num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3, 4, 5}, {6, 7}, {8}, {9, 10, 11}, {12, 13, 14, 15, 16}};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < input.length; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < input[i].length; j++) {
                subList.add(input[i][j]);
            }
            list.add(subList);
        }
        MetrixDiagonalOrder metrixDiagonalOrder = new MetrixDiagonalOrder();
        int[] diagonalOrder = metrixDiagonalOrder.findDiagonalOrder(list);
        System.out.println(Arrays.toString(diagonalOrder));
    }
}
