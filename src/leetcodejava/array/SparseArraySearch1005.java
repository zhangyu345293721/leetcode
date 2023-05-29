package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No. 1005 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-digits/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 稀疏数组搜索。有个排好序的字符串数组，其中散布着一些空字符串，编写一种方法，找出给定字符串的位置。
 *
 * 示例1:
 * 输入: words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta"
 * 输出：-1
 * 说明: 不存在返回-1。
 * 示例2:
 * 输入：words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ball"
 * 输出：4
 * 提示:
 *
 * words的长度在[1, 1000000]之间
 * 链接：https://leetcode.cn/problems/sparse-array-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class SparseArraySearch1005 {

    @Test
    public void addDigitsTest() {
        String []  words = ["at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""], s = "ta";
        int result = findString(words, s);
        Assert.assertEquals(result, -1);
    }
    /**
    * 查找字符串
    */
    public int findString(String[] words, String s) {
        int left = 0;
        int right = words.length - 1;
        while(left <= right){
            // 防止数组下标溢出
            int mid = (right - left) / 2 + left;
            if(words[mid].equals("")){
                if(words[left].compareTo(s) == 0){
                    return left;
                } else {
                    left = left + 1;
                }
            } else if(words[mid].compareTo(s) < 0 ){
                left = mid + 1;
            } else if(words[mid].compareTo(s) > 0){
                right = mid - 1;
            } else {
                return mid;
            }
          }
          return -1;
    }
}
