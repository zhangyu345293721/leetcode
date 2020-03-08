package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 重构队列
 *
 * @author: zhangyu
 */
public class ReconstructQueue406 {
    @Test
    public void testReconstructQueue() {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] result = reconstructQueue(people);
        System.out.println(result);
    }

    /**
     * @param people 人序号
     * @return 数组
     */
    private int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> res = new LinkedList<>();
        for (int[] cur : people) {
            res.add(cur[1], cur);
        }
        return res.toArray(new int[people.length][]);
    }
}
