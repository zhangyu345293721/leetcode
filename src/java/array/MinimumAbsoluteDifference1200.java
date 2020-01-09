package java.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 找出绝对值最小
 *
 * @author: zhangyu
 */
public class MinimumAbsoluteDifference1200 {
    @Test
    public void testMinimumAbsoluteDifference2() {
        int[] arr = {4, 2, 1, 3};
        List<List<Integer>> list = minimumAbsDifference(arr);
        System.out.println(list);
    }

    /**
     * 找出绝对值差最小的组（leetcode上超时，）
     *
     * @param arr 数组
     * @return 镶嵌链表
     */
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int gap = Math.abs(arr[j] - arr[i]);
                if (gap < min) {
                    min = gap;
                }
            }
        }
        List<List<Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int gap = Math.abs(arr[j] - arr[i]);
                if (gap == min) {
                    List<Integer> list = new ArrayList<>();
                    list.add(arr[j]);
                    list.add(arr[i]);
                    Collections.sort(list);
                    pairList.add(list);
                }
            }
        }
        return pairList;
    }

    /**
     * 找出绝对值差最小的组
     *
     * @param arr 数组
     * @return 镶嵌链表
     */
    public List<List<Integer>> minimumAbsDifference2(int[] arr) {
        int min = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            min = Math.min(min, Math.abs(arr[i + 1] - arr[i]));
        }
        List<List<Integer>> pairList = new ArrayList<>();
        for (int i = 0; i < arr.length - 1; i++) {
            int gap = Math.abs(arr[i + 1] - arr[i]);
            if (gap == min) {
                List<Integer> list = new ArrayList<>(Arrays.asList(arr[i], arr[i + 1]));
                pairList.add(list);
            }
        }
        return pairList;
    }
}
