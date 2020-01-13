package leetcodejava.array;

import org.junit.Test;

/**
 * 动量数组
 *
 * @author: zhangyu
 */
public class MonotonicArray896 {

    @Test
    public void testMonotonicArray() {
        int[] arr = {1, 1, 1};
        boolean flag = isMonotonic(arr);
        System.out.println(flag);
    }

    /**
     * 动量数组
     *
     * @param A 数组
     * @return 返回是否递增和递减
     */
    public boolean isMonotonic(int[] A) {
        if (A.length < 2) {
            return true;
        }
        int count1 = 0;
        int count2 = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i - 1] <= A[i]) {
                count1++;
            }
            if (A[i - 1] >= A[i]) {
                count2++;
            }
        }
        int time = A.length - 1;
        return count1 == time || count2 == time;
    }
}
