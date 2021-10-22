package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No. 697 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/diving-board-lcci
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为shorter，长度较长的木板长度为longer。你必须正好使用k块木板。编写一个方法，生成跳水板所有可能的长度。
 * <p>
 * 返回的长度需要从小到大排列。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * shorter = 1
 * longer = 2
 * k = 3
 * 输出： {3,4,5,6}
 * 提示：
 * <p>
 * 0 < shorter <= longer
 * 0 <= k <= 100000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/diving-board-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DivingBoardLCCI {

    @Test
    public void divingBoardLCCITest() {
        int shorter = 2;
        int longer = 1118596;
        int k = 979;
        int[] result = divingBoard(shorter, longer, k);
        Assert.assertEquals(result[0], 1958);
    }

    /**
     * 拼接跳板
     *
     * @param shorter 端数
     * @param longer  长数
     * @param k       个数
     * @return 数组
     */
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k <= 0) {
            return new int[0];
        }
        if (longer == shorter) {
            return new int[]{shorter * k};
        }
        List<Integer> set = new ArrayList<>();
        for (int i = k; i >= 0; i--) {
            int left = k - i;
            set.add(shorter * i + longer * left);
        }
        return set.stream().mapToInt(e -> e.intValue()).toArray();
    }


    /**
     * 拼接跳板
     *
     * @param shorter 端数
     * @param longer  长数
     * @param k       个数
     * @return 数组
     */
    public int[] divingBoard2(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[]{};
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] result = new int[k + 1];
        int start = shorter * k;
        for (int i = 0; i <= k; i++) {
            result[i] = start + (longer - shorter) * i;
        }
        return result;
    }
}
