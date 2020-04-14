package leetcodejava.hashtable.twitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This is the solution of No. 355 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/design-twitter/
 *
 * The description of problem is as follow:
 * ==========================================================================================================
 * 设计一个简化版的推特(Twitter)，可以让用户实现发送推文，关注/取消关注其他用户，能够看见关注人（包括自己）的最近十条推文。你的设计需要支持以下的几个功能：
 *
 * postTweet(userId, tweetId): 创建一条新的推文
 * getNewsFeed(userId): 检索最近的十条推文。每个推文都必须是由此用户关注的人或者是用户自己发出的。推文必须按照时间顺序由最近的开始排序。
 * follow(followerId, followeeId): 关注一个用户
 * unfollow(followerId, followeeId): 取消关注一个用户
 * 示例:
 *
 * Twitter twitter = new Twitter();
 *
 * // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
 * twitter.postTweet(1, 5);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * twitter.getNewsFeed(1);
 *
 * // 用户1关注了用户2.
 * twitter.follow(1, 2);
 *
 * // 用户2发送了一个新推文 (推文id = 6).
 * twitter.postTweet(2, 6);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
 * // 推文id6应当在推文id5之前，因为它是在5之后发送的.
 * twitter.getNewsFeed(1);
 *
 * // 用户1取消关注了用户2.
 * twitter.unfollow(1, 2);
 *
 * // 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
 * // 因为用户1已经不再关注用户2.
 * twitter.getNewsFeed(1);
 *
 * 来源：力扣（LeetCode）
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
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
