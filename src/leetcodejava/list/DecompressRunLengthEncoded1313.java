package leetcodejava.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 解压数组
 *
 * @author: zhangyu
 */
public class DecompressRunLengthEncoded1313 {
    @Test
    public void testDecompressRunLengthEncoded() {
        int[] nums = {1, 2, 3, 4};
        int[] arr = decompressRLElist(nums);
        System.out.println(arr);
    }

    /**
     * 解压链表
     *
     * @param nums 数组
     * @return 解压后数组
     */
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            int time = nums[i];
            int num = nums[i + 1];
            for (int j = 0; j < time; j++) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }
}
