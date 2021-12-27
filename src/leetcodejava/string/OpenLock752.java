package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.752 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/open-the-lock
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：
 * 例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * <p>
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * <p>
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * <p>
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1 。
 * <p>
 * 示例 1:
 * <p>
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 * 示例 2:
 * <p>
 * 输入: deadends = ["8888"], target = "0009"
 * 输出：1
 * 解释：
 * 把最后一位反向旋转一次即可 "0000" -> "0009"。
 * 示例 3:
 * <p>
 * 输入: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * 输出：-1
 * 解释：
 * 无法旋转到目标数字且不被锁定。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/open-the-lock
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class OpenLock752 {
    @Test
    public void openLockTest() {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        String target = "0202";
        int result = openLock(deadends, target);
        System.out.println(result);
        Assert.assertEquals(result, 6);
    }

    /**
     * 查找最早打开锁的次数
     *
     * @param deadends 死锁节点
     * @param target   目标点
     * @return 次数
     */
    public int openLock(String[] deadends, String target) {
        if ("0000".equals(target)) {
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        if (dead.contains("0000")) {
            return -1;
        }
        int result = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        while (!queue.isEmpty()) {
            ++result;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                String status = queue.poll();
                for (String nextStatus : getNextString(status)) {
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)) {
                            return result;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    /**
     * 下一个字符串
     *
     * @param p 字符串-
     * @return 目标字符串
     */
    public List<String> getNextString(String p) {
        List<String> nextStrs = new ArrayList<>();
        // 上下翻转情况
        int[] d = new int[]{-1, 1};
        for (int j = 0; j < p.length(); j++) {
            char[] nums = p.toCharArray();
            for (int n : d) {
                nums[j] = (char) ((p.charAt(j) - '0' + n + 10) % 10 + '0');
                nextStrs.add(new String(nums));
            }
        }
        return nextStrs;
    }
}
