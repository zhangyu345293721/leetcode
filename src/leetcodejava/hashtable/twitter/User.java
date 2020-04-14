package leetcodejava.hashtable.twitter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: zhangyu
 */
public class User {
    Integer id;
    List<User> follows;

    public User(Integer id) {
        this.id = id;
        this.follows = new ArrayList<>();
    }
}
