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
 * @Description: 利用比较器对数组进行排序
 * @date 2018/12/10 11:03
 **/


public class QueueReconstruction2 {
    @Test
    public void fun() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] queue = resortPeople(people);
       /* for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < people[i].length; j++) {
                System.out.print(people[i][j] + " ");
            }
            System.out.println();
        }*/
        for (int i = 0; i < queue.length; i++) {
            for (int j = 0; j < queue[i].length; j++) {
                System.out.print(queue[i][j] + " ");
            }
            System.out.println();
        }
    }

    int[][] resortPeople(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return a[1] - b[1];
                } else {
                    return b[0] - a[0];  // 按照第一列逆序，如果第一列相等，就按照第二例顺序
                    // return a[0] == b[0] ? a[1] - b[1] : b[0] - a[0];
                }
            }
        });
        return people;
    }
}
