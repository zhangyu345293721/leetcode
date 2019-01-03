package leetcode.testlist;

import org.junit.Test;

/**
 * @author zhangyu
 * @version V1.0
 * @ClassName: TestTreeNode
 * @Description: TOTO
 * @date 2018/12/6 21:33
 **/


public class TestTreeNode {
    @Test
    public void fun(){
       TreeNode root=new TreeNode(4);
       root=root.left;
       root.left=new TreeNode(7);
       root=root.right;
       root.right=new TreeNode(2);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return null;
        }

        //TreeNode right=invertTree(root.right);
        //TreeNode left=invertTree(root.left);
        // root.left=right;
        //root.right=left;

        invertTree(root.left);
        //System.out.println(root.val);
        invertTree(root.right);
        System.out.println(root.val);
        return root;

    }
}
