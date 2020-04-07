package leetcodejava.list;

import java.util.*;

/**
 * @author: zhangyu
 */
public class LFUCache4602 {
    Map<Integer, int[]> cacheMap;
    Map<Integer, List<int[]>> frequentlyMap;
    int size;
    int capacity;
    int min;

    public LFUCache4602(int capacity) {
        cacheMap = new HashMap<>(capacity);
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
        int[] node = cacheMap.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node[1];
    }

    /**
     * 插入一个值
     * int arr[]={key,value,time}
     *
     * @param key   key
     * @param value value
     */
    public void put(int key, int value) {
        if (capacity == 0) {
            return;
        }
        int[] node = cacheMap.get(key);
        if (node != null) {
            // 更新value
            node[1] = value;
            updateNode(node);
        } else {
            if (size == capacity) {
                int[] deadNode = removeNode();
                cacheMap.remove(deadNode[0]);
                size--;
            }
            int[] newNode = new int[]{key, value, 1};
            cacheMap.put(key, newNode);
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
        List<int[]> list = frequentlyMap.get(freq);
        list.remove(node);
        if (freq == min && list.size() == 0) {
            min = freq + 1;
        }
        node[2]++;
        List<int[]> newList = frequentlyMap.get(freq + 1);
        if (newList == null) {
            newList = new LinkedList<>();
            frequentlyMap.put(freq + 1, newList);
        }
        newList.add(node);
    }

    /**
     * 增加元素
     *
     * @param node 节点
     */
    public void addNode(int[] node) {
        List<int[]> list = frequentlyMap.get(1);
        if (list == null) {
            list = new LinkedList<>();
            frequentlyMap.put(1, list);
        }
        list.add(node);
        min = 1;
    }

    /**
     * 删除第一个元素
     *
     * @return 返回第一个元素[
     */
    public int[] removeNode() {
        List<int[]> list = frequentlyMap.get(min);
        int[] deadNode = list.get(0);
        list.remove(deadNode);
        return deadNode;
    }
}
