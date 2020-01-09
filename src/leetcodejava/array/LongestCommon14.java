package leetcodejava.array;


import org.junit.Test;

/**
 * 最长前缀
 *
 * @author: zhangyu
 */
public class LongestCommon14 {

    @Test
    public void longestCommonTestDemo() {
        String[] strs = {"c", "c"};
        String longestStr = longestCommonPrefix(strs);
        System.out.println("longestStr = " + longestStr);
    }

    /**
     * 最长相同字符串
     *
     * @param strs 输入字符串
     * @return 返回最长相同字符串
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length < 1) {
            return "";
        }
        if (strs.length < 2) {
            return strs[0];
        }
        String longestStr = "";
        for (int i = 1; i <= strs[0].length(); i++) {
            String sub = strs[0].substring(0, i);
            boolean flag = isAllMatch(sub, strs);
            if (flag) {
                longestStr = sub;
            } else {
                return longestStr;
            }
        }
        return longestStr;
    }

    /**
     * 是否全部匹配
     *
     * @param sub  输入子串
     * @param strs 总的字符串
     * @return 返回布尔值
     */
    private boolean isAllMatch(String sub, String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(sub)) {
                return false;
            }
        }
        return true;
    }
}
