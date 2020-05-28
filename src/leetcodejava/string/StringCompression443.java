package leetcodejava.string;

import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the solution of No.443 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/string-compression
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定一组字符，使用原地算法将其压缩。
 *
 * 压缩后的长度必须始终小于或等于原数组长度。
 *
 * 数组的每个元素应该是长度为1 的字符（不是 int 整数类型）。
 *
 * 在完成原地修改输入数组后，返回数组的新长度。
 *
 * 进阶：
 * 你能否仅使用O(1) 空间解决问题？
 *
 * 示例 1：
 * 输入：
 * ["a","a","b","b","c","c","c"]
 *
 * 输出：
 * 返回6，输入数组的前6个字符应该是：["a","2","b","2","c","3"]
 *
 * 说明：
 * "aa"被"a2"替代。"bb"被"b2"替代。"ccc"被"c3"替代。
 * 示例 2：
 * 输入：
 * ["a"]
 *
 * 输出：
 * 返回1，输入数组的前1个字符应该是：["a"]
 *
 * 说明：
 * 没有任何字符串被替代。
 * 示例 3：
 *
 * 输入：
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 *
 * 输出：
 * 返回4，输入数组的前4个字符应该是：["a","b","1","2"]。
 *
 * 说明：
 * 由于字符"a"不重复，所以不会被压缩。"bbbbbbbbbbbb"被“b12”替代。
 * 注意每个数字在数组中都有它自己的位置。
 * 注意：
 *
 * 所有字符都有一个ASCII值在[35, 126]区间内。
 * 1 <= len(chars) <= 1000。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-compression
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class StringCompression443 {

    @Test
    public void testStringCompression() {
        String[] strs = {"a", "a", "b", "b", "c", "c", "c"};
        int num = compress(strs);
        System.out.println(num);
    }

    /**
     * 压缩字符串，把子串转成压缩形式
     *
     * @param chars 字符串数组
     * @return 长度
     */
    public int compress(String[] chars) {
        int pos = 0;
        List<String> list = new ArrayList();
        while (pos < chars.length) {
            int count = 1;
            while (pos < chars.length - 1 && chars[pos] == chars[pos + 1]) {
                pos++;
                count++;
            }
            if (count == 1) {
                list.add(String.valueOf(chars[pos]));
            } else {
                int length = String.valueOf(count).length();
                list.add(String.valueOf(chars[pos]));
                for (int i = 0; i < length; i++) {
                    char ch = String.valueOf(count).charAt(i);
                    list.add(String.valueOf(ch));
                }
            }
            pos++;
        }
        System.out.println(list);
        return list.size();
    }
}
