package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: HashSetTest
 * @Description: TOTO
 * @date 2018/12/13 14:42
 **/


public class HashSetTest {
    @Test
    public void fun() {
        List<String> list=new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("a");
        Set<String> set=new HashSet<String>(list);
        System.out.println(set);
    }
}
