package leetcode.TestWeb;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: DirectionTest
 * @Description: TOTO
 * @date 2018/12/17 21:40
 **/


public class DirectionTest {
    @Test
    public void fun() {
        Direction d = Direction.LEFT;
        switch (d) {
            case FRONT:
                System.out.println("前面");
                break;
            case BEHIND:
                System.out.println("后面");
                break;
            case LEFT:
                System.out.println("左边");
                break;
            case RIGHT:
                System.out.println("RIGHT");
                break;
            default:
                System.out.println("错误的方向");
        }
        Direction.LEFT.fun();
        Direction d1=d;
        System.out.println(d1);
    }
}