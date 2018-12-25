package leetcode.reflect;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: Person
 * @Description: TOTO
 * @date 2018/12/18 10:00
 **/


public class Person {
    private String name;
    private String id;

    public Person() {
    }

    public Person(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {

        return name;
    }

    public String getId() {
        return id;
    }
}
