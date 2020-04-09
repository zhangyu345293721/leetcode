package leetcodejava.list;

import java.util.LinkedHashMap;
import java.util.Map;

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
public class LRUCache146_2 {
    private static Map<Integer, int[]> cache = null;
    private int capacity = 0;


    public LRUCache146_2(int capacity) {
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
