package leetcode;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ListSort
 * @Description: TOTO
 * @date 2018/12/5 21:33
 **/


public class ListSort {
    @Test
    public void fun() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(4);
        Collections.sort(list);
        System.out.println(list);
    }

    @Test
    public void fun2() {
        Set<Integer> set=new TreeSet<>();
        set.add(2);
        set.add(1);
        set.add(3);

    }
}
