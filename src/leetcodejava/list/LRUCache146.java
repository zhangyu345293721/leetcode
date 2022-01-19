package leetcodejava.list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This is the solution of No. 146 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LRUCache146 {
    private List<int[]> list = null;
    private int capacity;

    public LRUCache146(int capacity) {
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

class LRUCache146_1 {
    private static Map<Integer, int[]> cache = null;
    private int capacity = 0;


    public LRUCache146_1(int capacity) {
        cache = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    /**
     * 获取key的值
     *
     * @param key key
     * @return value
     */
    public int get(int key) {
        if (cache.containsKey(key)) {
            int[] ints = cache.get(key);
            updateMap(key, ints);
            return ints[1];
        }
        return -1;
    }

    public void updateMap(int key, int[] arr) {
        cache.remove(key);
        cache.put(key, arr);
    }

    /**
     * 向LRU中插入值
     *
     * @param key   key
     * @param value value
     */
    public void put(int key, int value) {
        int[] arr = new int[]{key, value};
        //如果存在这个key就更新value
        if (cache.containsKey(key)) {
            updateMap(key, arr);
            return;
        }
        if (cache.size() < capacity) {
            cache.put(key, arr);
        } else if (cache.size() == capacity) {
            int deleteKey = cache.entrySet().iterator().next().getKey();
            updateMap(deleteKey, arr);
        }
    }
}

class LRUCache146_2 {

    /**
     * 缓存的容量空间
     */
    private int capacity;
    /**
     * 装缓存的map
     */
    Map<Integer, Node> map;
    /**
     * 双向链表
     */
    DoubleLinkedList doubleLinkedList;

    public LRUCache146_2(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        doubleLinkedList = new DoubleLinkedList();
    }

    /**
     * 获取key的值
     *
     * @param key key
     * @return value
     */
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node node = map.get(key);
        doubleLinkedList.removeNode(node);
        doubleLinkedList.addHead(node);
        return node.value;
    }

    /**
     * 向LRU中插入值
     *
     * @param key   key
     * @param value value
     */
    public void put(int key, int value) {
        // 如果key存在
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedList.removeNode(node);
            doubleLinkedList.addHead(node);
        } else {
            // 长度超过缓存长度
            if (map.size() >= capacity) {
                Node last = doubleLinkedList.getLast();
                map.remove(last.key);
                doubleLinkedList.removeNode(last);
            }
            // 新增
            Node node = new Node(key, value);
            map.put(key, node);
            doubleLinkedList.addHead(node);
        }
    }

    class Node {
        /**
         * 链表的key值
         */
        Integer key;
        /**
         * 链表的value值
         */
        Integer value;
        /**
         * 链表的前驱节点
         */
        Node prev;
        /**
         * 链表的后驱节点
         */
        Node next;

        public Node() {
            this.prev = null;
            this.next = null;
        }

        /**
         * 构造方法
         *
         * @param key   key值
         * @param value value值
         */
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
            this.prev = null;
            this.next = null;
        }
    }

    class DoubleLinkedList {
        Node head;
        Node tail;

        /**
         * 构建doublelist
         */
        public DoubleLinkedList() {
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }

        /**
         * 添加到头
         */
        public void addHead(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }

        /**
         * 删除节点
         */
        public void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = null;
            node.next = null;
        }

        /**
         * 获得最后一个节点
         */
        public Node getLast() {
            return tail.prev;
        }
    }
}