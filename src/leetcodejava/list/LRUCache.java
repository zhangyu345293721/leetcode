package leetcodejava.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 最少访问次数缓存
 *
 * @author: zhangyu
 */
public class LRUCache {
    private List<int[]> list = null;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        list = new CopyOnWriteArrayList<>();
    }

    /**
     * 获取元素
     *
     * @param key 关键字
     * @return value
     */
    public int get(int key) {
        for (int[] ints : list) {
            if (ints[0] == key) {
                list.remove(ints);
                list.add(ints);
                return ints[1];
            }
        }
        return -1;
    }


    /**
     * 插入key,value
     *
     * @param key   关键字
     * @param value value
     */
    public void put(int key, int value) {
        int[] arr = new int[]{key, value};
        for (int[] ints : list) {
            if (ints[0] == key) {
                list.remove(ints);
                ints[1] = value;
                list.add(ints);
                return;
            }
        }
        if (list.size() < capacity) {
            list.add(arr);
        } else if (list.size() == capacity) {
            list.remove(0);
            list.add(arr);
        }
    }
}