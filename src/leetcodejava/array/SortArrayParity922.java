package leetcodejava.array;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * This is the solution of No. 922 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/sort-array-by-parity-ii
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 *
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 *  
 * 提示：
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 *  
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SortArrayParity922 {

    @Test
    public void testSortArrayParity() {
        int[] A = {4, 2, 5, 7};
        int[] arr = sortArrayByParityII(A);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

    /**
     * 排序数组
     *
     * @param A 输入数组A
     * @return 新数组
     */
    public int[] sortArrayByParityII(int[] A) {
        Deque<Integer> odd = new LinkedList<>();
        Deque<Integer> even = new LinkedList<>();
        for (int num : A) {
            if (num % 2 == 0) {
                even.push(num);
            } else {
                odd.push(num);
            }
        }
        for (int i = 0; i < A.length; i++) {
            if (i % 2 == 0) {
                A[i] = even.pop();
            } else {
                A[i] = odd.pop();
            }
        }
        return A;
    }
}
