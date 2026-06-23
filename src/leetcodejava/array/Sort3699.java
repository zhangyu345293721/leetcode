package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No. 3699 problem in the LeetCode,
 * the website of the problem is as follow:
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 三个整数：n, l, r
 *（n: 数组长度, l, r: 每个元素的取值范围为 [l, r]（闭区间）
 * 要求构造一个长度为 n 的数组，满足以下条件：
 * 每个元素 ∈ [l, r]
 * 任意两个相邻元素不相等（即不能有重复的连续值）
 * 任意三个连续元素不能构成严格递增或严格递减序列
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Sort3699 {

    @Test
    public void Sort3699Test() {
        int n = 3;
        int l = 1;
        int r = 3;
        long result = countZigzag(n, l, r);
        System.out.println(result);
    }
    
    public long countZigzag(int n, int l, int r) {
        return searchHelper(0, -1, false, n, l, r);
    }
    long searchHelper(int pos, int last, boolean up, int n, int l, int r) {
        if (pos == n) {
            return 1;
        }
        String key = pos + "," + last + "," + up;
        // memory get
        if (memory.containsKey(key)) {
            return memory.get(key);
        }
        long count = 0;
        for (int val = l; val <= r; val++) {
            if (pos == 0) {
                // 第一个数，随便填
                count += searchHelper(pos + 1, val, true, n, l, r);
            } else {
                boolean currentUp = val > last;
                // 要求：当前趋势与上次相反
                if (currentUp != up) {
                    count += searchHelper(pos + 1, val, currentUp, n, l, r);
                }
            }
        }
        // cache hash map
        memory.put(key, count);
        return count;
    }
}
