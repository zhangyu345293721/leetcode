package leetcodejava.list;

import java.util.Iterator;
import java.util.Map;

/**
 * @author: zhangyu
 */
public class TestLinkedHashMapDemo {


    public static void main(String[] args) throws Exception {
        //指定缓存最大容量为4
        Map<Integer, Integer> map = new LRULinkedHashMap<>(4);
        map.put(9, 3);
        map.put(7, 4);
        map.put(5, 9);
        map.put(3, 4);
        map.put(6, 6);
        map.get(9);
        //遍历结果
        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            System.out.println(it.next().getKey());
        }
    }
}
