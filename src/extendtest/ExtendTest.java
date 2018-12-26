package extendtest;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ExtendTest
 * @Description: TOTO
 * @date 2018/12/26 15:46
 **/

class Info<T> {
    private T var;

    public void setVar(T var) {
        this.var = var;
    }

    public T getVar(T var) {
        return this.var;
    }

    public String toString() {
        return this.var.toString();
    }
}

public class ExtendTest {
    @Test
    public void fun() {
        Info<Integer> i1 = new Info<>();
        Info<Float> i2 = new Info<>();
        i1.setVar(30);
        i2.setVar(30.1f);
        fun(i1);
        fun(i2);
    }

    public void fun(Info<? extends Number> temp) {
        System.out.println(temp + ",");
    }

    @Test
    public void  fun2(){
        Number a=4;
        Integer b=5;//这些包装类都继承了Number 类
        System.out.println(4);
    }
}
