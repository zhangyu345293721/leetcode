package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class QuestionView64 {

    @Test
    public void questionViewTest() {
        int num = lastRemaining(10, 17);
        System.out.println(num);
    }

    /**
     * 最后一个数
     *
     * @param n 数字
     * @param m 数的数字
     * @return 最后的值
     */
    public int lastRemaining(int n, int m) {
        List<Integer> josephList = new ArrayList();
        for (int i = 0; i < n; i++) {
            josephList.add(i);
        }
        int start = 0;
        int length = josephList.size();
        for (int i = 1; i < length; i++) {
            start = (start + m - 1) % josephList.size();
            josephList.remove(start);
        }
        return josephList.get(0);
    }
}
