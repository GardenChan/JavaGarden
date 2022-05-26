package dream.high_frequency;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/3 2:04
 * author: Garden Chan
 * description: 使用LinkedHashMap实现LRU
 */
public class SimpleLRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRY_SIZE = 3;

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRY_SIZE;
    }

    SimpleLRUCache(){
        super(MAX_ENTRY_SIZE, 0.75f, true);
    }

    public static void main(String[] args) {
        SimpleLRUCache<Integer, String> LRU = new SimpleLRUCache<>();
        LRU.put(1, "a");
        LRU.put(2, "b");
        LRU.put(3, "c");
        System.out.println(LRU);
        LRU.get(1);
        System.out.println(LRU);
        LRU.put(4, "d");
        System.out.println(LRU);
    }
}
