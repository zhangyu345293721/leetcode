package leetcode.tree;

import org.junit.Test;

import java.util.List;

/**
 * @author: zhangyu
 */
public class RunTest {
    @Test
    public void runTestDemo() {
        //假设二叉树中的数据为： 1,2,3,4,5,6,7,8,9从上到下，从左至右
        int[] arrs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        BinaryTree binaryTree = new BinaryTree();
        List<BinaryTreeNode> binaryTreeNodes = binaryTree.initTree(arrs);
        BinaryTreeNode rootNode = binaryTreeNodes.get(0);
        binaryTree.setRoot(binaryTreeNodes.get(0));

        System.out.println(binaryTree.getTreeHeight());
        System.out.println(binaryTree.getSize());

        //先序遍历结果
        System.out.println("递归先序遍历结果: ");
        binaryTree.preOrderTraverse(rootNode);
        System.out.println("\n循环先序遍历结果: ");
        binaryTree.preOrderTraverseByWhile(rootNode);
        //中序遍历结果
        System.out.println("\n中序遍历结果: ");
        binaryTree.inOrderTraverse(rootNode);
        System.out.println("\n循环中序遍历结果: ");
        binaryTree.inOrderTraverse(rootNode);
        //后序遍历结果
        System.out.println("\n后序遍历结果: ");
        binaryTree.afterOrderTraverse(rootNode);
        System.out.println("\n循环后序遍历结果: ");
        binaryTree.afterOrderTraverseByWhile(rootNode);
    }
}
