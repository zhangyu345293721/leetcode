package leetcodejava.list;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * This is the solution of No. 146 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 *
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥已经存在，则变更其数据值；如果密钥不存在，则插入该组「密钥/数据值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * 进阶:
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class LRUCache146_1 {
    private List<int[]> list = null;
    private int capacity;

    public LRUCache146_1(int capacity) {
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