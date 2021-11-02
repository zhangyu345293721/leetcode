package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 771 problem in the book <i>Coding Interviews: Questions, Analysis & Solutions</i>,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/jewels-and-stones/
 * The description of problem is as follow:
 * ==========================================================================================================
 * 给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，
 * 你想知道你拥有的石头中有多少是宝石。J 中的字母不重复，J 和 S中的所有字符都是字母。
 * 字母区分大小写，因此"a"和"A"是不同类型的石头。
 * <p>
 * 示例 1:
 * <p>
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: J = "z", S = "ZZ"
 * 输出: 0
 * 注意:
 * <p>
 * S 和 J 最多含有50个字母。
 *  J 中的字符不重复。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jewels-and-stones
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class JewelsAndStones771 {

    @Test
    public void jewelsAndStonesTest() {
        String J = "aA";
        String S = "aAAbbbb";
        int result = numJewelsInStones(J, S);
        Assert.assertEquals(result, 3);
        System.out.println(result);
    }

    /**
     * 计算宝石的个数
     *
     * @param jewels 字符串J
     * @param stones 字符串S
     * @return int
     */
    private int numJewelsInStones(String jewels, String stones) {
        if (jewels.length() < 1) {
            return 0;
        }
        int count = 0;
        Set<Character> chSet = new HashSet<>();
        for (char ch : jewels.toCharArray()) {
            chSet.add(ch);
        }
        for (char ch : stones.toCharArray()) {
            if (chSet.contains(ch)) {
                count += 1;
            }
        }
        return count;
    }
    /**
     * 计算宝石的个数
     *
     * @param jewels 字符串J
     * @param stones 字符串S
     * @return int
     */
    private int numJewelsInStones2(String jewels, String stones) {
        if (jewels.length() < 1) {
            return 0;
        }
        int count = 0;
        for (char ch : stones.toCharArray()) {
            if (jewels.contains(String.valueOf(ch))) {
                count += 1;
            }
        }
        return count;
    }
}
