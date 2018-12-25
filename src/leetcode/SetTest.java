package leetcode;

import org.junit.Test;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: SetTest
 * @Description: TOTO
 * @date 2018/12/14 15:53
 **/


public class SetTest {
    @Test
    public void fun() {
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(3);
        set.add(1);
        for (int num : set) {
            System.out.println(num);
        }
    }
}
