package leetcodejava.list;

import java.util.*;

/**
 * This is the solution of No.460 problem in the LeetCode,
 * the website of the problem is as follow:
 *https://leetcode-cn.com/problems/lfu-cache
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。它应该支持以下操作：get 和 put。
 *
 * get(key) - 如果键存在于缓存中，则获取键的值（总是正数），否则返回 -1。
 * put(key, value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除最久未使用的键。
 * 「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。
 *
 *  
 *
 * 进阶：
 * 你是否可以在 O(1) 时间复杂度内执行两项操作？
 *
 * 示例：
 *
 * LFUCache cache = new LFUCache( 2 );
 *
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回 1
 * cache.put(3,3);    // 去除 key 2
 * cache.get(2);       // 返回 -1 (未找到key 2)
 * cache.get(3);       // 返回 3
 * cache.put(4,4);    // 去除 key 1
 * cache.get(1);       // 返回 -1 (未找到 key 1)
 * cache.get(3);       // 返回 3
 * cache.get(4);       // 返回 4
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lfu-cache
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LFUCache460 {
    Map<Integer, Node> cache;  // 存储缓存的内容
    Map<Integer, LinkedHashSet<Node>> freqMap; // 存储每个频次对应的双向链表
    int size;
    int capacity;
    int min; // 存储当前最小频次

    public LFUCache460(int capacity) {
        cache = new HashMap<>(capacity);
        freqMap = new HashMap<>();
        this.capacity = capacity;
    }

    /**
     * 获取元素
     *
     * @param key key
     * @return value
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        updateNode(node);
        return node.value;
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
        Node node = cache.get(key);
        if (node != null) {
            // 更新value
            node.value = value;
            updateNode(node);
        } else {
            if (size == capacity) {
                Node deadNode = removeNode();
                cache.remove(deadNode.key);
                size--;
            }
            Node newNode = new Node(key, value);
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
    public void updateNode(Node node) {
        // 从原freq对应的链表里移除, 并更新min
        int freq = node.freq;
        LinkedHashSet<Node> set = freqMap.get(freq);
        set.remove(node);
        if (freq == min && set.size() == 0) {
            min = freq + 1;
        }
        // 加入新freq对应的链表
        node.freq++;
        LinkedHashSet<Node> newSet = freqMap.get(freq + 1);
        if (newSet == null) {
            newSet = new LinkedHashSet<>();
            freqMap.put(freq + 1, newSet);
        }
        newSet.add(node);
    }

    /**
     * 增加元素
     *
     * @param node 节点
     */
    public void addNode(Node node) {
        LinkedHashSet<Node> set = freqMap.get(1);
        if (set == null) {
            set = new LinkedHashSet<>();
            freqMap.put(1, set);
        }
        set.add(node);
        min = 1;
    }

    /**
     * 删除第一个元素
     *
     * @return 返回第一个元素
     */
    public Node removeNode() {
        LinkedHashSet<Node> set = freqMap.get(min);
        Node deadNode = set.iterator().next();
        set.remove(deadNode);
        return deadNode;
    }
}

class Node {
    int key;
    int value;
    int freq = 1;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}


class LFUCache4601 {
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


class LFUCache4602 {
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
