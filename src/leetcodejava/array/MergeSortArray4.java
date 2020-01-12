package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 合并数组
 *
 * @author: zhangyu
 */
public class MergeSortArray4 {

    @Test
    public void testMergeArray() {
        int[] nums1 = {1, 3};
        int[] nums2 = {2, 4};
        double median=getMedian(nums1,nums2);
        System.out.println(median);
    }

    /**
     * @param nums1 数组1
     * @param nums2 数组2
     * @return 中间数
     */
    public double getMedian(int[] nums1, int nums2[]) {
        List<Integer> list = new ArrayList();
        for(int num1:nums1){
            list.add(num1);
        }
        for(int num2:nums2){
            list.add(num2);
        }
        Collections.sort(list);
        int length = list.size() ;
        if (length % 2 == 0) {
            return (list.get((length-1) / 2 ) + list.get((length -1)/ 2 + 1)) / 2.0;
        } else {
            return list.get((length-1) / 2);
        }
    }
}
