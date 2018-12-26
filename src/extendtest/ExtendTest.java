package extendtest;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: ExtendTest
 * @Description:
 * ? extends Number 只接收实现Number类和Number类的子类
 * ? super String 只接收String类和String类的父类
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

       /* // 使用String为泛型类型
        Info<?> i = new Info<String>() ;
        // 设置内容，这里会出错，因为”？“通配符修饰的对象只能接收，不能修改，也就是不能设置。
        i.setVar("MLDN") ;*/
    }

    public void fun(Info<? extends Number> temp) {
        System.out.println(temp + ",");
    }

    @Test
    public void fun2() {
        Number a = 4;
        Integer b = 5;         //这些包装类都继承了Number 类
        System.out.println(4);
    }

    @Test
    public void fun3() {
        //设置下限
        Info<String> a = new Info<>();
        Info<Object> b = new Info<>();
        a.setVar("abc");
        b.setVar("def");
        function(a);
        function(b);
    }

    private void function(Info<? super String> a) {
        System.out.println(a.toString());
    }
}
