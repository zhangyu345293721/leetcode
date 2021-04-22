package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This is the solution of No. 350 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * 说明：
 * <p>
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 * 我们可以不考虑输出结果的顺序。
 * 进阶:
 * <p>
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-arrays-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class IntersectionTwoArrays350 {

    @Test
    public void intersectionTwoArraysTest() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int nums[] = intersect(nums1, nums2);
        System.out.println(nums);
        Assert.assertArrayEquals(nums, new int[]{2, 2});
    }

    /**
     * 求两个数组的交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组交集
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList();
        for (int num1 : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                if (num1 == nums2[j]) {
                    list.add(num1);
                    nums2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }

    /**
     * 求两个数组的交集
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组交集
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> list = new ArrayList<>();
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        return list.stream().mapToInt(e -> e).toArray();
    }
}
