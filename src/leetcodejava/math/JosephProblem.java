package leetcodejava.math;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * description:已知n个人（以编号1，2，3...n分别表示）围坐在一张圆桌周围。从编号为1的人开始报数，数到m的那个人出列；
 * 他的下一个人又从1开始报数，数到m的那个人又出列；依此规律重复下去，直到圆桌周围的人全部出列。（也类似于变态杀人狂问题）
 * 通常解决这类问题时我们把编号从0~n-1，最后结果+1即为原问题的解。通常，我们会要求输出最后一位出列的人的序号。
 * 那么这里主要研究的是最后一个出列的人的序号要怎么确定。
 *
 * @author: zhangyu
 * @date: 2021/1/7
 */
public class JosephProblem {

    @Test
    public void josephProblemTest() {
        int result = lastRemaining(7, 3);
        System.out.println(result);
        Assert.assertEquals(result, 3);
    }

    /**
     * 计算约瑟夫环返回最后一个数
     *
     * @param n 人个数
     * @param m 删除第m个数
     * @return 返回最后一个人
     */
    public int lastRemaining(int n, int m) {
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }

    /**
     * 计算约瑟夫环返回最后一个数
     *
     * @param n 人个数
     * @param m 删除第m个数
     * @return 返回最后一个人
     */
    public int lastRemaining2(int n, int m) {
        if (n == 0 || m == 0) {
            return -1;
        }
        List<Integer> peopleList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            peopleList.add(i);
        }
        int removeIndex = 0;
        while (peopleList.size() != 1) {
            removeIndex = (removeIndex + m - 1) % peopleList.size();
            peopleList.remove(removeIndex);
        }
        return peopleList.get(0);
    }
}
