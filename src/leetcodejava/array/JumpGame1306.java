package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1306 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/jump-game-iii
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 这里有一个非负整数数组 arr，你最开始位于该数组的起始下标 start 处。当你位于下标 i 处时，你可以跳到 i + arr[i] 或者 i - arr[i]。
 * <p>
 * 请你判断自己是否能够跳到对应元素值为 0 的 任一 下标处。
 * <p>
 * 注意，不管是什么情况下，你都无法跳到数组之外。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 5
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 5 -> 下标 4 -> 下标 1 -> 下标 3
 * 下标 5 -> 下标 6 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 2：
 * <p>
 * 输入：arr = [4,2,3,0,3,1,2], start = 0
 * 输出：true
 * 解释：
 * 到达值为 0 的下标 3 有以下可能方案：
 * 下标 0 -> 下标 4 -> 下标 1 -> 下标 3
 * 示例 3：
 * <p>
 * 输入：arr = [3,0,2,1,2], start = 2
 * 输出：false
 * 解释：无法到达值为 0 的下标 1 处。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game-iii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class JumpGame1306 {

    @Test
    public void jumpGameTest() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 0;
        boolean result = canReach(arr, start);
        System.out.println(result);
        Assert.assertEquals(result, true);
    }

    boolean[] visited = null;
    boolean result = false;

    /**
     * 查找能否到达0
     *
     * @param arr   数组
     * @param start 开始节点
     * @return 布尔值
     */
    public boolean canReach(int[] arr, int start) {
        visited = new boolean[arr.length];
        searchHelper(arr, start);
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param arr 数组
     * @param i   下标
     */
    public void searchHelper(int[] arr, int i) {
        if (arr[i] == 0) {
            result = true;
        }
        int len = arr.length;
        // 向左边跳
        int curLeft = i - arr[i];
        if (curLeft >= 0 && curLeft < len && !visited[curLeft]) {
            visited[curLeft] = true;
            searchHelper(arr, curLeft);
        }
        // 向右边跳
        int curRight = i + arr[i];
        if (curRight >= 0 && curRight < len && !visited[curRight]) {
            visited[curRight] = true;
            searchHelper(arr, curRight);
        }
    }
}
