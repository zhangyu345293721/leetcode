package leetcodejava.list;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author: zhangyu
 */
public class LFUCache4601 {
    Map<Integer, int[]> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<int[]>> frequentlyMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache4601(int capacity) {
        cache = new HashMap<>(capacity);
        frequentlyMap = new HashMap<>();
        this.capacity = capacity;
    }

    /**
     * 获取元素
     *
     * @param key key
     * @return value
     */
    public int get(int key) {
        int[] node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node[1];
    }

    /**
     * 插入一个值
     *
     * @param key   key
     * @param value value
     */
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        int[] node = cache.get(key);
        if (node != null) {
            // 更新value
            node[1] = value;
            updateNode(node);
        } else {
            if (size == capacity) {
                int[] deadNode = removeNode();
                cache.remove(deadNode[0]);
                size--;
            }
            int[] newNode = new int[]{key, value, 1};
            cache.put(key, newNode);
            addNode(newNode);
            size++;
        }
    }

    /**
     * 更新频次
     *
     * @param node 节点
     */
    public void updateNode(int[] node) {
        int freq = node[2];
        LinkedHashSet<int[]> set = frequentlyMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node[2]++;
        LinkedHashSet<int[]> newSet = frequentlyMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            frequentlyMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    /**
     * 增加元素
     *
     * @param node 节点
     */
    public void addNode(int[] node) {
        LinkedHashSet<int[]> set = frequentlyMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            frequentlyMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    /**
     * 删除第一个元素
     *
     * @return 返回第一个元素
     */
    public int[] removeNode() {
        LinkedHashSet<int[]> set = frequentlyMap.get(min);
        int[] deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}
