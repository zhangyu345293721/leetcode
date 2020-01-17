package leetcodejava.array;

import org.junit.Test;

/**
 * 找出数组最高点的下标
 *
 * @author: zhangyu
 */
public class PeakIndexMountainArray852 {
    @Test
    public void testPeakIndexMountainArray() {
        int[] arr = {0, 2, 1, 0};
        int index = peakIndexInMountainArray(arr);
        System.out.println(index);
    }

    /**
     * 找出最高点的下标
     *
     * @param A 数组
     * @return 下标
     */
    public int peakIndexInMountainArray(int[] A) {
        if (A == null || A.length < 3) {
            return -1;
        }
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
