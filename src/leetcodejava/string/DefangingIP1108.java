package leetcodejava.string;


import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1002 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/defanging-an-ip-address
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
 * <p>
 * 所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
 * <p>
 * 示例 1：
 * <p>
 * 输入：address = "1.1.1.1"
 * 输出："1[.]1[.]1[.]1"
 * 示例 2：
 * <p>
 * 输入：address = "255.100.50.0"
 * 输出："255[.]100[.]50[.]0"
 * <p>
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class DefangingIP1108 {

    @Test
    public void defangingIpTest() {
        String address = "255.100.50.0";
        String s = defangIPaddr2(address);
        System.out.println("s = " + s);
        Assert.assertEquals(s,"255[.]100[.]50[.]0");
    }

    /**
     * 对于.位置改为[.]
     *
     * @param address 地址
     * @return 字符串
     */
    public String defangIPaddr(String address) {
        return address.replaceAll("\\.", "[\\.]");
    }

    /**
     * 对于.位置改为[.]
     *
     * @param address 地址
     * @return 修改
     */
    public String defangIPaddr2(String address) {
        StringBuilder sb = new StringBuilder();
        for (char ch : address.toCharArray()) {
            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
