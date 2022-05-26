package dream.high_frequency;



import java.util.*;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/7 16:28
 * author: Jiading chen
 * description: NC97 字符串出现次数的TopK问题
 */
public class TopKString {
    /**
     * return topK string
     * @param strings string字符串一维数组 strings
     * @param k int整型 the k
     * @return string字符串二维数组
     */
    public String[][] topKstrings (String[] strings, int k) {
        // write code here
        Map<String, Integer> map = new HashMap<>();
        for (String string : strings) {
            if (map.containsKey(string)) {
                map.put(string, map.get(string) + 1);
            }else {
                map.put(string, 1);
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry);
        }
        list.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return !o2.getValue().equals(o1.getValue()) ? o2.getValue() - o1.getValue() : o1.getKey().compareTo(o2.getKey());
            }
        });
        String[][] res = new String[k][2];
        for (int i = 0; i < k; i++) {
            res[i][0] = list.get(i).getKey();
            res[i][1] = list.get(i).getValue().toString();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] input = {"123","123","231","32"};
        TopKString topKString = new TopKString();
        String[][] strings = topKString.topKstrings(input, 2);
        System.out.println(Arrays.deepToString(strings));
    }
}
