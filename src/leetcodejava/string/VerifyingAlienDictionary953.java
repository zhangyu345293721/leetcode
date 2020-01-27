package leetcodejava.string;

/**
 * 按照外部字典顺序
 *
 * @author: zhangyu
 */
public class VerifyingAlienDictionary953 {

    /**
     * 判断字符串是否按照顺序
     *
     * @param words 字符串
     * @param order 顺序串
     * @return 布尔值
     */
    public boolean isAlienSorted(String[] words, String order) {
        int N = words.length;
        for (int i = 0; i < N - 1; i++) {
            boolean flag = compare(words[i], words[i + 1], order);
            if (!flag) return false;
        }
        return true;
    }

    /**
     * 判断两个字符串是否按照顺序
     *
     * @param word1 字符串1
     * @param word2 字符串2
     * @param order 顺序字符串
     * @return 布尔值
     */
    private boolean compare(String word1, String word2, String order) {
        int i = 0;
        int N1 = word1.length();
        int N2 = word2.length();
        while (i < N1 && i < N2 && word1.charAt(i) == word2.charAt(i)) {
            i++;
        }
        if (i == N1 || i == N2) {
            return N1 < N2;
        }
        return order.indexOf(word1.charAt(i)) < order.indexOf(word2.charAt(i));
    }
}
