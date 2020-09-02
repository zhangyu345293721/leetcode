package leetcodejava.hashtable.twitter;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义用户
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class User {
    /**
     * 定义用户的id
     */
    Integer id;
    /**
     * 定义用户
     */
    List<User> follows;

    public User(Integer id) {
        this.id = id;
        this.follows = new ArrayList<>();
    }
}
