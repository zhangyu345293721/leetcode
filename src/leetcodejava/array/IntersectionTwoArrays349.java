package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.349 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/find-n-unique-integers-sum-up-to-zero
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * 说明：
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class IntersectionTwoArrays349 {


    @Test
    public void intersectionTwoArraysTest() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = intersection(nums1, nums2);
        Assert.assertArrayEquals(result, new int[]{2});
    }

    /**
     * 两个数组求交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length < 1) {
            return null;
        }
        if (nums2 == null || nums2.length < 1) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    /**
     * 两个数组求交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 交集数组
     */
    private int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1.length < 1 || nums2.length < 1 || nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num1 : nums1) {
            set.add(num1);
        }
        List<Integer> list = new ArrayList<>();
        for (int num2 : nums2) {
            if (set.contains(num2)) {
                list.add(num2);
                set.remove(num2);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
