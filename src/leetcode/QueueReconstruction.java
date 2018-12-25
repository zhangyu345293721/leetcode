package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: QueueReconstruction
 * @Description: TOTO
 * @date 2018/12/10 11:03
 **/


public class QueueReconstruction {
    @Test
    public void fun() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = reconstructQueue(people);
       /* for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[i].length; j++) {
                System.out.print(people[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    // 对people进行排序，h越大k越小的排越前，然后按顺序先给个子高的排位置，再给个子矮的排
    // 因为个子高的位置排好后，再怎么对个子矮的排，都不会影响个子高的人的相对位置
    private int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1]; // 如果第一列相同，按照第二例顺序排序
                } else {
                    return b[0] - a[0]; // 按照第一列逆序排序
                }
                //return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
            }
        });
       /* for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[i].length; j++) {
                System.out.print(people[i][j] + " ");
            }
            System.out.println();
        }*/
        // System.out.println("--------------------------------------------------");

        List<int[]> res = new LinkedList<>(); //链表里面存储的是一个一维数组
        for (int[] cur : people) {
            // 遍历每一个人的位置
            res.add(cur[1], cur);
            // System.out.println(cur[0] + "==" + cur[1]);
        }
        /* for (int[] arr : res) {
            System.out.println(arr[0] + "--------" + arr[1]);
        }*/
        // System.out.println(res);
        return res.toArray(new int[people.length][]);// 把链表变成数组
    }
}
