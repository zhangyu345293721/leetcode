package leetcodejava.list;

import org.junit.Test;

/**
 * @author: zhangyu
 */
public class LRUCacheDemo2 {
    @Test
    public void testLRUDemo2() {
        LRUCache146_2 lruCache2 = new LRUCache146_2(2);
        lruCache2.get(2);
        lruCache2.put(2, 6);
        lruCache2.get(1);
        lruCache2.put(1, 5);
        lruCache2.put(1, 2);
        lruCache2.get(1);
        lruCache2.get(2);

    }
}
