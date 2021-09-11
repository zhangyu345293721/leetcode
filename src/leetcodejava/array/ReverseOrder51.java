package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

public class ReverseOrder51 {

    @Test
    public void reverseOrderTest() {
        int[] nums = {7, 5, 6, 4};
        int result = reversePairs(nums);
        System.out.println(result);
        Assert.assertEquals(result, 5);
    }

    int[] temp;

    /**
     * 求逆序对
     *
     * @param nums 数组
     * @return 逆序对总数
     */
    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1);
    }

    /**
     * 归并排序
     *
     * @param nums 数组
     * @param l    坐标l
     * @param r    坐标r
     * @return 数量
     */
    public int mergeSort(int[] nums, int l, int r) {
        if (l >= r) {
            return 0;
        }
        int m = (l + r) / 2;
        int res = mergeSort(nums, l, m) + mergeSort(nums, m + 1, r);
        // 合并阶段
        int i = l, j = m + 1;
        for (int k = l; k <= r; k++) {
            temp[k] = nums[k];
        }
        for (int k = l; k <= r; k++) {
            if (i == m + 1) {
                nums[k] = temp[j++];
            } else if (j == r + 1 || temp[i] <= temp[j]) {
                nums[k] = temp[i++];
            } else {
                nums[k] = temp[j++];
                res += m - i + 1;  // 统计逆序对
            }
        }
        return res;
    }
}
