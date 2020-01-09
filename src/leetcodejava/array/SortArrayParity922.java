package leetcodejava.array;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 进行排序
 *
 * @author: zhangyu
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
