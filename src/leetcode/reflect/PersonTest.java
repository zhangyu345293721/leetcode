package leetcode.reflect;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: PersonTest
 * @Description: TOTO
 * @date 2018/12/18 10:04
 **/


public class PersonTest {
    // 对对象进行反射
    @Test
    public void fun1() throws Exception {
        Class c = Class.forName("leetcode.reflect.Person");
        Person p = (Person) c.newInstance();
        p.setId("123");
        System.out.println(p.getId());
    }

    // 对构造方法进行反射
    @Test
    public void fun2() throws Exception {
        Class c = Class.forName("leetcode.reflect.Person");
        Constructor cc = c.getConstructor(String.class, String.class);
        cc.setAccessible(true);
        Person p = (Person) cc.newInstance("zhangsan", "123");
        System.out.println(p.getId() + " " + p.getName());
    }

    // 对字段进行反射
    @Test
    public void fun3() throws Exception {
        Class c = Class.forName("leetcode.reflect.Person");
        Person p = (Person) c.newInstance();
        Field f1 = c.getDeclaredField("name");
        f1.setAccessible(true);
        f1.set(p, "zhangyu");//相当于p.name="zhangyu";
        System.out.println(f1.get(p));//相当于 p.name
    }

    // 对普通方法进行反射
    @Test
    public void fun4() throws Exception {
        // 1.获取类的字节码文件
        Class c = Class.forName("leetcode.reflect.Person");
        // 2.获取对象
        Person p = (Person) c.newInstance();
        // 3.获取普通方法
        Method m1 = c.getDeclaredMethod("setName", String.class);
        m1.setAccessible(true);
        m1.invoke(p,"mibao");
        System.out.println(p.getName());//相当于 p.name
    }
}
