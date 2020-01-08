package leetcode.math;

import org.junit.Test;

public class TrapWater42 {

	@Test
	public void testTrapWater() {
		int[] nums = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		int containsWater = trapWater(nums);
		System.out.println(containsWater);
	}

	private int trapWater(int[] nums) {
		int lmax = 0;
		int rmax = 0;
		int left = 0;
		int right = nums.length - 1;
		int totalWater = 0;
		while (left < right) {
			if (nums[left] < nums[right]) {

				lmax = Math.max(lmax, nums[left]);
				totalWater += (lmax - nums[left]);
				left++;
			} else {
				// 找出右边最大的一个数
				rmax = Math.max(rmax, nums[right]);
				totalWater += (rmax - nums[right]);
				right--;
			}
		}
		return totalWater;
	}
}
