package leetcodejava.array;

import org.junit.Test;

/**
 * This is the solution of No. 1299 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/replace-elements-with-greatest-element-on-right-side
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
 *
 * 完成所有替换操作后，请你返回这个数组。
 * 示例：
 *
 * 输入：arr = [17,18,5,4,6,1]
 * 输出：[18,6,6,6,1,-1]
 * 提示：
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class ReplaceGreatestRight1299 {
    @Test
    public void replaceGreatestRight() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] resultArr = replaceElements(arr);

        for (int i : resultArr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 取代数组
     *
     * @param arr 输入数组
     * @return 新数组
     */
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int leftMax = getLeftMax(arr, i + 1);
            arr[i] = leftMax;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    /**
     * 求剩余数组中最大值
     *
     * @param arr 数组
     * @param i   下标
     * @return 最大值
     */
    private int getLeftMax(int[] arr, int i) {
        int max = Integer.MIN_VALUE;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        return max;
    }
}
