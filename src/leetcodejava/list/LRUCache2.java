package leetcodejava.list;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author: zhangyu
 */
public class LRUCache2 {
    private Map<Integer, int[]> cache = null;
    private int capacity = 0;


    public LRUCache2(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            int[] ints = cache.get(key);
            cache.remove(key);
            cache.put(key, ints);
            return ints[2];
        }
        return -1;
    }

    public void put(int key, int value) {
        int[] arr = new int[]{key, value};
        //如果存在这个key就更新value
        if (cache.containsKey(key)) {
            int[] ints = cache.get(key);
            cache.remove(key);
            ints[1] = value;
            cache.put(key, ints);
            return;
        }
        if (cache.size() < capacity) {
            cache.put(key, arr);
        } else if (cache.size() == capacity) {
            int key1 = cache.entrySet().iterator().next().getKey();
            cache.remove(key1);
            cache.put(key, arr);
        }
    }
}
