package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: zhangyu
 */
public class IncreasingSubsequences491 {

    @Test
    public void increasingSubsequencesTest() {
        int[] arr = {4, 6, 7, 7};
    }

    List<Integer> temp = new ArrayList<Integer>();
    List<List<Integer>> ans = new ArrayList<List<Integer>>();
    Set<Integer> set = new HashSet<Integer>();
    int n;

    /**
     * 寻找所有的子数组
     *
     * @param nums 数组
     * @return 数组
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        n = nums.length;
        for (int i = 0; i < (1 << n); ++i) {
            findSubsequences(i, nums);
            int hashValue = getHash(263, (int) 1E9 + 7);
            if (check() && !set.contains(hashValue)) {
                ans.add(new ArrayList<Integer>(temp));
                set.add(hashValue);
            }
        }
        return ans;
    }

    /**
     * 寻找子数组
     *
     * @param mask mask
     * @param nums 数组
     */
    public void findSubsequences(int mask, int[] nums) {
        temp.clear();
        for (int i = 0; i < n; ++i) {
            if ((mask & 1) != 0) {
                temp.add(nums[i]);
            }
            mask >>= 1;
        }
    }

    /**
     * 获取hash值
     *
     * @param base 基础位
     * @param mod  mod
     * @return hash值
     */
    public int getHash(int base, int mod) {
        int hashValue = 0;
        for (int x : temp) {
            hashValue = hashValue * base % mod + (x + 101);
            hashValue %= mod;
        }
        return hashValue;
    }

    /**
     * @return
     */
    public boolean check() {
        for (int i = 1; i < temp.size(); ++i) {
            if (temp.get(i) < temp.get(i - 1)) {
                return false;
            }
        }
        return temp.size() >= 2;
    }
}
