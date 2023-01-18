package leetcodejava.array;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.Offer.57 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-binary/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * 示例 1：
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 * 限制：
 * 1 <= target <= 10^5
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 *@author zhangyu (zhangyuyu417@gmail.com)
 */
public class FindContinuousSequence{
    @Test
    public void findContinuousSequenceTest() {
        int target = 9;
        int[][] result = findContinuousSequence(target);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    /**
     * 查找连续序列
     *
     * @param target 目标值
     * @return 二维数组
     */
    public int[][] findContinuousSequence(int target) {
        if(target == 0) {
            return new int[][]{};
        }
        List<int[]> temp = new ArrayList();
        int p = 1;
        int q = 2;
        int sum = 3;
        while(p < q) {
            if(sum == target) {
                int [] arr = new int[q - p + 1];
                int index = 0;
                for(int i = p; i <= q; i++) {
                    arr[index++] = i;
                }
                temp.add(arr);
                sum -= p;
                p++;
                q++;
                sum += q;
            } else if (sum > target) {
                sum -= p;
                p++;
            } else {
                q++;
                sum += q;
            }
        }
        // 将链表数据放入数组中
        int [][] result = new int[temp.size()][];
        for(int i = 0; i < temp.size(); i++) {
            result[i] = temp.get(i);
        }
        return result;
    }
}
