package leetcodejava.list;

import org.junit.Test;

/**
 * @author: zhangyu
 */
public class LRUCacheDemo {
    @Test
    public void testLRUDemo() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        lruCache.get(1);
        lruCache.put(3, 3);
        lruCache.get(2);
        lruCache.put(4, 4);
        lruCache.get(1);
        lruCache.get(3);
        lruCache.get(4);
    }
}
