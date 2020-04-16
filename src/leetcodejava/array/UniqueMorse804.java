package leetcodejava.array;


import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * This is the solution of No. 804 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/unique-morse-code-words
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 *
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 *
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + "-..." + ".-"字符串的结合)。我们将这样一个连接过程称作单词翻译。
 *
 * 返回我们可以获得所有词不同单词翻译的数量。
 *
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class UniqueMorse804 {

    @Test
    public void testUniqueMorse() {
        String[] words = {"gin", "zen", "gig", "msg"};
        int length = uniqueMorseRepresentations(words);
        System.out.println("length = " + length);
    }

    /**
     * @param words 输入单词数组
     * @return 返回个数
     */
    public int uniqueMorseRepresentations(String[] words) {
        String[] tableComparisons = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (char ch : word.toCharArray()) {
                int index = ch - 'a';
                sb.append(tableComparisons[index]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
