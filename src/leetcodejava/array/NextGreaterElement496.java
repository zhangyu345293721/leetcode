package leetcodejava.array;

import org.junit.Test;

/**
 * 下个数组中大的值
 *
 * @author: zhangyu
 */
public class NextGreaterElement496 {

    @Test
    public void testNextGreaterElement() {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        int[] array = nextGreaterElement(nums1, nums2);
        System.out.println(array);
    }

    /**
     * 下一个数组中大的
     *
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 数组
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] newArr = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int element = getNumber(nums2,  nums1[i]);
            newArr[i] = element;
        }
        return newArr;
    }

    /**
     * 找出nums2中有没有元素大于num
     *
     * @param nums2 数组num2
     * @param num   数字
     * @return 返回数
     */
    private int getNumber(int[] nums2,  int num) {
        int index = getIndex(nums2, num);
        if (index == nums2.length - 1) {
            return -1;
        }
        for (int i = index + 1; i < nums2.length; i++) {
            if (nums2[i] > num) {
                return nums2[i];
            }
        }
        return -1;
    }

    /**
     * 获取树
     *
     * @param nums2 数组2
     * @param num   数字
     * @return 下标
     */
    private int getIndex(int[] nums2, int num) {
        for (int i = 0; i < nums2.length; i++) {
            if (num == nums2[i]) {
                return i;
            }
        }
        return -1;
    }
}
