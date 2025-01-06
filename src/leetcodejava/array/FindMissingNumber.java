package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * find missging two number
 *
 * @author zhangyu
 **/

public class FindMissingNumber {
    @Test
    public void findMissingNumberTest() {
          findingMissNumber(num);
    }

    public static void findingMissNumber(int[] nums, int k) {
      int[] copyArr = nums;
      while (k-- > 0) {
          int len = nums.length;
          int first = findingMissFirstNumber(copyArr);
          // copy array and add first number
          copyArr = new int[len + 1];
          for (int i = 0; i < len; i++) {
              copyArr[i] = nums[i];
          }
          copyArr[len] = first;
          // change numbers array
          nums = copyArr;
          result.add(first);
      }
    }

    /**
     * find miss two number form 1-n array
     *
     * @param nums 1-n array
     * @return missing value
     */
    public static int findingMissFirstNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int len = nums.length;
        // swap number to right location
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        // missing first value
        for (int i = 0; i < len; i++) {
            if (nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
