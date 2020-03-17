package leetcodejava.string;

import org.junit.Test;

/**
 * 检测大小写
 *
 * @author: zhangyu
 */
public class DetectCapital520 {

    @Test
    public void testDetectCapital() {
        String word = "USA";
        boolean flag = detectCapitalUse(word);
        System.out.println(flag);
    }

    /**
     * 检测大小写字符串
     *
     * @param word 字符串
     * @return 布尔值
     */
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) {
            return true;
        }
        boolean firstCharFlag = word.charAt(0) < 97;
        boolean secondCharFlag = word.charAt(1) < 97;

        if (!firstCharFlag && secondCharFlag) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            boolean charFlag = word.charAt(i) < 97;
            if (!secondCharFlag && charFlag) {
                return false;
            }
            if (secondCharFlag && !charFlag) {
                return false;
            }
        }
        return true;
    }
}
