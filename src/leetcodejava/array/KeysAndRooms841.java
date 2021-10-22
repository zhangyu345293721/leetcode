package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.offer 841 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/keys-and-rooms
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 有 N 个房间，开始时你位于 0 号房间。每个房间有不同的号码：0，1，2，...，N-1，并且房间里可能有一些钥匙能使你进入下一个房间。
 * 在形式上，对于每个房间 i 都有一个钥匙列表 rooms[i]，每个钥匙 rooms[i][j] 由 [0,1，...，N-1] 中的一个整数表示，其中 N = rooms.length。 钥匙 rooms[i][j] = v 可以打开编号为 v 的房间。
 * 最初，除 0 号房间外的其余所有房间都被锁住。
 * 你可以自由地在房间之间来回走动。
 * 如果能进入每个房间返回 true，否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入: [[1],[2],[3],[]]
 * 输出: true
 * 解释:
 * 我们从 0 号房间开始，拿到钥匙 1。
 * 之后我们去 1 号房间，拿到钥匙 2。
 * 然后我们去 2 号房间，拿到钥匙 3。
 * 最后我们去了 3 号房间。
 * 由于我们能够进入每个房间，我们返回 true。
 * 示例 2：
 * 输入：[[1,3],[3,0,1],[2],[0]]
 * 输出：false
 * 解释：我们不能进入 2 号房间。
 * 提示：
 * <p>
 * 1 <= rooms.length <= 1000
 * 0 <= rooms[i].length <= 1000
 * 所有房间中的钥匙数量总计不超过 3000。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/keys-and-rooms
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class KeysAndRooms841 {
    @Test
    public void keysAndRoomsTest() {
        List<List<Integer>> rooms = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(new Integer[]{1, 3});
        List<Integer> list2 = Arrays.asList(new Integer[]{3, 0, 1});
        List<Integer> list3 = Arrays.asList(new Integer[]{2});
        List<Integer> list4 = Arrays.asList(new Integer[]{0});
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);
        rooms.add(list4);
        boolean result= canVisitAllRooms(rooms);
        Assert.assertEquals(result, false);
    }

    boolean[] vis;
    int num;

    /**
     * 能够访问的房间数
     *
     * @param rooms 房间链表
     * @return 布尔值
     */
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    /**
     * 房间链表
     *
     * @param rooms 房间链表
     * @param x     下标
     */
    public void dfs(List<List<Integer>> rooms, int x) {
        vis[x] = true;
        num++;
        for (int it : rooms.get(x)) {
            if (!vis[it]) {
                dfs(rooms, it);
            }
        }
    }

    /**
     * 能够访问的房间数
     *
     * @param rooms 房间链表
     * @return 布尔值
     */
    public boolean canVisitAllRooms2(List<List<Integer>> rooms) {
        int n = rooms.size(), num = 0;
        boolean[] vis = new boolean[n];
        Queue<Integer> que = new LinkedList<>();
        vis[0] = true;
        que.offer(0);
        while (!que.isEmpty()) {
            int x = que.poll();
            num++;
            for (int it : rooms.get(x)) {
                if (!vis[it]) {
                    vis[it] = true;
                    que.offer(it);
                }
            }
        }
        return num == n;
    }
}
