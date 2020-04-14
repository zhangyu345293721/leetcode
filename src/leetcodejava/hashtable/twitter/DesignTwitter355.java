package leetcodejava.hashtable.twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 推特设计
 *
 * @author: zhangyu
 */
public class DesignTwitter355 {
    List<Tweet> tweets;
    HashMap<Integer, User> users;

    public DesignTwitter355() {
        users = new HashMap<>();
        tweets = new ArrayList<>();
    }

    /**
     * 发送推特
     *
     * @param userId  用户id
     * @param tweetId 推特id
     */
    public void postTweet(int userId, int tweetId) {
        User user = users.get(userId);
        if (user == null) {
            user = new User(userId);
        }
        Tweet tweet = new Tweet(userId, tweetId);
        tweets.add(tweet);
        users.put(userId, user);
    }

    /**
     * 获取自己发的或者关注的人的前10天推特
     *
     * @param userId 用户id
     * @return 推特链表
     */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        User user = users.get(userId);
        if (user == null) {
            return list;
        }
        List<User> follows = user.follows;
        for (int i = tweets.size() - 1; i >= 0; i--) {
            Tweet tweet = tweets.get(i);
            if (user.id == tweet.userId) {
                list.add(tweet.tweetId);
            }
            if (list.size() == 10) {
                return list;
            }
            for (User u : follows) {
                if (user.id.equals(u.id)) {
                    continue;
                }
                if (u.id == tweet.userId) {
                    list.add(tweet.tweetId);
                }
                if (list.size() == 10) {
                    return list;
                }
            }
        }
        return list;
    }

    /**
     * 关注用户
     *
     * @param followerId 自己id
     * @param followeeId 关注者id
     */
    public void follow(int followerId, int followeeId) {
        User user = users.get(followerId);
        User f = users.get(followeeId);
        if (f == null) {
            f = new User(followeeId);
        }
        if (user == null) {
            user = new User(followerId);
            users.put(followerId, user);
            user.follows.add(f);
            return;
        }
        for (User u : user.follows) {
            // 已经关注过了
            if (u.id == followeeId) {
                return;
            }
        }
        users.put(followeeId, f);
        user.follows.add(f);
    }

    /**
     * 取消关注
     *
     * @param followerId 自己id
     * @param followeeId 取消关注人id
     */
    public void unfollow(int followerId, int followeeId) {
        User user = users.get(followerId);
        if (user == null) {
            return;
        }
        List<User> followUsers = user.follows;
        for (int i = 0; i < followUsers.size(); i++) {
            if (followUsers.get(i).id == followeeId) {
                followUsers.remove(i);
                break;
            }
        }
    }
}
