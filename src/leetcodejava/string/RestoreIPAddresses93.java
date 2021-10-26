package leetcodejava.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.93 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/restore-ip-addresses
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * <p>
 * 有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * <p>
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class RestoreIPAddresses93 {

    @Test
    public void restoreIPAddressesTest() {
        String s = "25525511135";
        List<String> result = restoreIpAddresses(s);
        System.out.println(result);
        Assert.assertEquals(result.size(), 2);
    }

    List<String> result = new ArrayList<>();
    int[] segments = null;

    /**
     * 修复ip
     *
     * @param s 字符串
     * @return ip链表
     */
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() < 4 || s.length() > 12) {
            return result;
        }
        segments = new int[4];
        searchHelper(s, 0, 0);
        return result;
    }

    /**
     * 深度优先遍历
     *
     * @param s     字符串
     * @param segId 部分id
     * @param start 开始位置
     */
    public void searchHelper(String s, int segId, int start) {
        // 如果找到了 4 段 IP 地址并且遍历完了字符串，那么就是一种答案
        if (segId == 4) {
            if (start == s.length()) {
                StringBuilder ipAddress = new StringBuilder();
                for (int i = 0; i < 4; ++i) {
                    ipAddress.append(segments[i]);
                    if (i != 3) {
                        ipAddress.append('.');
                    }
                }
                result.add(ipAddress.toString());
            }
            return;
        }
        if (start == s.length()) {
            return;
        }
        // 由于不能有零在数字前面，如果当前数字为 0
        if (s.charAt(start) == '0') {
            segments[segId] = 0;
            searchHelper(s, segId + 1, start + 1);
        }
        // 一般情况，枚举每一种可能性并递归
        int addr = 0;
        for (int i = start; i < s.length(); ++i) {
            addr = addr * 10 + (s.charAt(i) - '0');
            if (addr > 0 && addr <= 255) {
                segments[segId] = addr;
                searchHelper(s, segId + 1, i + 1);
            } else {
                break;
            }
        }
    }
}
