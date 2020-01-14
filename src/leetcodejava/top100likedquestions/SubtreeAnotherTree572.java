package leetcodejava.top100likedquestions;

/**
 * 判断一棵树是不是另一棵树的子树
 *
 * @author: zhangyu
 */
public class SubtreeAnotherTree572 {


    /**
     * 判断一棵树是不是另一颗的子树
     *
     * @param s 树s
     * @param t 树t
     * @return 布尔值
     */
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }

        if (s.val == t.val && isSame(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * 判断两棵树是不是一样
     *
     * @param t1 节点1
     * @param t2 节点2
     * @return 布尔值
     */
    private boolean isSame(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }

        if (t1.val == t2.val) {
            return isSame(t1.left, t2.left) && isSame(t1.right, t2.right);
        } else {
            return false;
        }
    }
}
