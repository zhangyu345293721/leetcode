package leetcodejava.tree;

/**
 * 二叉搜索树的构建，查找，插入，删除
 *
 * @author: zhangyu
 */
public class BinarySearchTree {

    private TreeNode root;

    /**
     * 查找树插入元素
     *
     * @param val 插入的值
     */
    public void insertIntoBST(int val) {
        root = insertIntoBST(root, val);
    }

    /**
     * 向二叉搜索树中插入元素
     *
     * @param root 根节点
     * @param val  插入值
     * @return 根节点
     */
    private TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    /**
     * 像搜索二叉树中插入元素
     *
     * @param data 数值
     */
    public void insertIntoBST2(int data) {
        if (root == null) {
            root = new TreeNode(data);
            return;
        }
        TreeNode p = root;
        while (p != null) {
            if (data > p.val) {
                if (p.right == null) {
                    p.right = new TreeNode(data);
                    return;
                }
                p = p.right;
            } else {
                if (p.left == null) {
                    p.left = new TreeNode(data);
                    return;
                }
                p = p.left;
            }
        }
    }


    /**
     * 二叉查找树,递归方式
     *
     * @param root 根节点
     * @param val  查找的值
     * @return 查找节点
     */
    private TreeNode searchBST1(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }
        if (val > root.val) {
            return searchBST1(root.right, val);
        } else {
            return searchBST1(root.left, val);
        }
    }


    /**
     * 查找树，查看节点是否存在
     *
     * @param data 数值
     * @return 根节点
     */
    public TreeNode searchBST2(TreeNode root, int data) {
        TreeNode p = root;
        while (p != null) {
            if (data < p.val) {
                p = p.left;
            } else if (data > p.val) {
                p = p.right;
            } else {
                return p;
            }
        }
        return null;
    }

    /**
     * 删除一个节点（判断节点）
     *
     * @param data 数值
     */
    public void delete(int data) {
        TreeNode p = root;
        TreeNode pp = null;
        // 找出要删除节点的父节点
        while (p != null && p.val != data) {
            pp = p;
            if (data > p.val) {
                p = p.right;
            } else {
                p = p.left;
            }
        }
        // 没有找到相等的退出
        if (p == null) {
            return;
        }
        // 删除的节点有两个子节点
        if (p.left != null && p.right != null) {
            TreeNode minP = p.right;
            TreeNode minPP = p;
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            // 赋值节点
            p.val = minP.val;
            // 删除叶子节点
            minPP.left = null;
            return;
        } else {  // 删除的节点是叶子节点或者有一个子节点
            TreeNode child;
            if (p.left != null) {
                child = p.left;
            } else if (p.right != null) {
                child = p.right;
            } else {
                child = null;
            }
            if (pp == null) {
                root = child;
            } else if (pp.left == p) {
                pp.left = child;
            } else {
                pp.right = child;
            }
        }
    }
}
