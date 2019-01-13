package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: MergeKSortedLists
 * @Description: TOTO
 * @date 2018/12/12 19:31
 **/


public class MergeKSortedLists {
    @Test
    public void fun() {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(4);
        list1.add(5);
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        list1.add(4);
        List<Integer> list3 = new ArrayList<>();
        list1.add(2);
        list1.add(6);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        List newList = mergeKSortedLists(list);
    }

    private List mergeKSortedLists(List<List<Integer>> list) {
        List<Integer> newList = new ArrayList<>();
        int i = 0;
        while (i < list.size()) {


        }
        return list;
    }

    private void merge2SortedLists(List<Integer> list, List<Integer> list1, List<Integer> list2) {
        int j = 0;
        int k = 0;
        while (j < list1.size() && k < list2.size()) {
            if (list1.get(j) < list2.get(k)) {
                list.add(list1.get(j));
                j++;
            } else {
                list.add(list2.get(k));
                k++;
            }
        }
        while (j < list1.size()) {
            list.add(list1.get(j));
            j++;
        }
        while(k<list2.size()){
            list.add(list2.get(k));
            k++;
        }
    }
}
