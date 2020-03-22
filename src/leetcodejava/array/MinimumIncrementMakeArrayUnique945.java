package leetcodejava.array;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 找最小没有重合数组
 *
 * @author: zhangyu
 */
public class MinimumIncrementMakeArrayUnique945 {
    @Test
    public void testMinimumIncrementMakeArrayUnique() {
        int[] A = {3, 2, 1, 2, 1, 7};
        int i = minIncrementForUnique(A);
        System.out.println(i);
    }

    /**
     * 数组A最小不重复
     *
     * @param A 数组A
     * @return 步数
     */
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int count = 0;
        Set<Integer> set = new HashSet<>();
        int i = 0;
        while (i < A.length) {
            if (set.contains(A[i])) {
                count++;
                A[i]++;
            } else {
                set.add(A[i]);
                i++;
            }
        }
        return count;
    }
}
