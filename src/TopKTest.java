//package leetcode;

import java.util.*;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: TopKTest
 * @Description: TOTO
 * @date 2018/12/21 20:29
 **/

public class TopKTest {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 2, 3, 5, 4, 1, 2, 3, 4, 6, 7};
        int k = 3;
        Map<Integer, Integer> map = new TreeMap();
        for (int i = 0; i < arr.length; i++) {
            if (!map.keySet().contains(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
       /*   for (int i : map.keySet()) {
            System.out.println(i + " :" + map.get(i));
        }*/
        List<Integer> list = new ArrayList();
        List<Integer> newList = new ArrayList<Integer>();
        for (int i : map.keySet()) {
            list.add(map.get(i));
        }
        Collections.sort(list);
        Collections.reverse(list);
        for (int i = 0; i < k; i++) {
            for (int key : map.keySet()) {
                if (map.get(key) == list.get(i)) {
                    newList.add(key);
                    map.put(key, 0);
                }
            }
        }
        System.out.println(newList.toString());
    }
}
