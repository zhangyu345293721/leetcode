package leetcode.question.traversebinarytree;

import leetcode.question.reverseTree226.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: zhangyu
 */
public class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return root;
    }

    public void setRoot(BinaryTreeNode root) {
        this.root = root;
    }

    public List<BinaryTreeNode> initTree(int[] arrs) {
        List<BinaryTreeNode> nodes = new ArrayList<BinaryTreeNode>();
        for (int data : arrs) {
            nodes.add(new BinaryTreeNode(data));
        }
        //arrs.length / 2 - 1是确保最后一个节点的左右子节点都存在
        for (int parentIndex = 0; parentIndex < arrs.length / 2 - 1; parentIndex++) {
            nodes.get(parentIndex).setLeftNode(nodes.get(parentIndex * 2 + 1));
            nodes.get(parentIndex).setRightNode(nodes.get(parentIndex * 2 + 2));
        }
        int lastParentIndex = arrs.length / 2 - 1;
        nodes.get(lastParentIndex).setLeftNode(nodes.get(lastParentIndex * 2 + 1));
        if (arrs.length % 2 != 0) {
            nodes.get(lastParentIndex).setRightNode(nodes.get(lastParentIndex * 2 + 2));
        }
        return nodes;
    }

    /**
     * 添加左结点
     *
     * @param child 添加该结点到左子树
     */
    public void setLeftChild(BinaryTreeNode child) {
        this.root.setLeftNode(child);
    }

    /**
     * 添加右结点
     *
     * @param child 添加该结点到右子树
     */
    public void setRightChild(BinaryTreeNode child) {
        this.root.setRightNode(child);
    }

    /**
     * 删除结点
     *
     * @param node 删除该节点
     * @return
     */
    public void deleteNode(BinaryTreeNode node) {
        if (node == null) {
            return;
        }

        deleteNode(node.getLeftNode());
        deleteNode(node.getRightNode());
        node = null;
    }

    /**
     * 清空二叉树
     *
     * @return
     */

    public void clear() {
        if (this.root != null) {
            this.deleteNode(this.root);
        }
    }

    /**
     * 获取二叉树指定结点的高度
     *
     * @param node 获取该节点的高度
     */
    public int getHeight(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        return Math.max(getHeight(node.getLeftNode()), getHeight(node.getRightNode())) + 1;
    }

    /**
     * 获取二叉树的高度
     *
     * @return int
     */
    public int getTreeHeight() {
        return this.getHeight(this.root);
    }

    /**
     * 获取二叉树指定节点的节点个数(包括指定节点)
     *
     * @param node 获取该节点的节点数
     * @return int
     */
    public int getChildSize(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftSize = getChildSize(node.getLeftNode());
        int rightSize = getChildSize(node.getRightNode());

        return leftSize + rightSize + 1;
    }

    /**
     * 获取二叉树的节点数
     *
     * @return int
     */
    public int getSize() {
        return this.getChildSize(this.root);
    }

    /**
     * 获取指定节点的父亲节点
     *
     * @param node
     * @return BinaryTreeNode
     */
    public BinaryTreeNode getParent(BinaryTreeNode node) {
        if (this.root == null || this.root == node) {
            return null;
        }
        return getParent(this.root, node);
    }

    /**
     * 递归对比 节点的孩子节点 与 指定节点 是否一致
     *
     * @param subTree 子二叉树根节点
     * @param node    指定节点
     * @return
     */
    public BinaryTreeNode getParent(BinaryTreeNode subTree, BinaryTreeNode node) {
        if (subTree == null) {
            return null;
        }

        if (subTree.getLeftNode() == node || subTree.getRightNode() == node) {
            return subTree;
        }

        BinaryTreeNode parent;
        if ((parent = getParent(subTree.getLeftNode(), node)) != null) {
            return parent;
        }

        return getParent(subTree.getRightNode(), node);
    }

    /**
     * 先序遍历二叉树： 根左右
     * <p>
     * 使用递归
     *
     * @param node 遍历的节点
     */
    public void preOrderTraverse(BinaryTreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.getLeftNode());
        preOrderTraverse(node.getRightNode());
    }

    /**
     * 先序遍历二叉树： 根左右
     * <p>
     * 使用循环
     *
     * @param node 遍历的节点
     */
    public void preOrderTraverseByWhile(BinaryTreeNode node) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();
        stack.push(node);
        BinaryTreeNode currentNode;
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            System.out.print(currentNode.data + " ");
            if (currentNode.getRightNode() != null) {
                stack.push(currentNode.getRightNode());
            }
            if (currentNode.getLeftNode() != null) {
                stack.push(currentNode.getLeftNode());
            }
        }
    }

    /**
     * 中序遍历二叉树： 左根右
     * <p>
     * 使用递归
     *
     * @param node 遍历的节点
     */
    public void inOrderTraverse(BinaryTreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.getLeftNode()); //递归输出左节点
        System.out.print(node.data + " ");
        inOrderTraverse(node.getRightNode()); //递归输出右节点
    }

    /**
     * 中序遍历二叉树： 左根右
     * <p>
     * 使用循环
     *
     * @param node 遍历的节点
     */
    public void inOrderTraverseByWhile(BinaryTreeNode node) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode currentNode = node;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeftNode();
            }
            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                System.out.print(currentNode.data + "");
                currentNode = currentNode.getRightNode();
            }
        }
    }

    /**
     * 后序遍历二叉树： 左右根
     * <p>
     * 使用递归
     *
     * @param node 遍历的节点
     */
    public void afterOrderTraverse(BinaryTreeNode node) {
        if (node == null)
            return;
        afterOrderTraverse(node.getLeftNode());//递归输出左节点
        afterOrderTraverse(node.getRightNode());//递归输出右节点
        System.out.print(node.data + " ");
    }

    /**
     * 后序遍历二叉树： 左右根
     * <p>
     * 使用循环
     *
     * @param node 遍历的节点
     */
    public void afterOrderTraverseByWhile(BinaryTreeNode node) {
        LinkedList<BinaryTreeNode> stack = new LinkedList<BinaryTreeNode>();
        BinaryTreeNode rightNode = null;
        BinaryTreeNode currentNode = node;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeftNode();
            }
            currentNode = stack.pop();
            //当上一个访问的结点是右孩子或者当前结点没有右孩子则访问当前结点
            while (currentNode != null && (currentNode.getRightNode() == null
                    || currentNode.getRightNode() == rightNode)) {
                System.out.print(currentNode.data + " ");
                rightNode = currentNode;
                if (stack.isEmpty()) {
                    return;
                }
                currentNode = stack.pop();
            }
            stack.push(currentNode);
            currentNode = currentNode.getRightNode();
        }
    }

    /**
     * 先序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，仅仅是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.getVal() + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 中序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的，仅仅是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public void inOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.getVal() + " ");
        inOrderTraverse(node.right);
    }

    /**
     * 后序遍历
     * <p>
     * 这三种不同的遍历结构都是一样的。仅仅是先后顺序不一样而已
     *
     * @param node 遍历的节点
     */
    public void postOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.getVal() + " ");
    }

    /**
     * 深度优先遍历，相当于先根遍历
     * 採用非递归实现
     * 须要辅助数据结构：栈
     */
    public void depthOrderTraversal(TreeNode root) {
        System.out.println("\n深度优先遍历");
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> stack = new ArrayDeque();
        stack.push(root);
        while (stack.isEmpty() == false) {
            TreeNode node = stack.pop();
            System.out.print(node.getVal() + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.print("\n");
    }

    /**
     * 广度优先遍历
     * 採用非递归实现
     * 须要辅助数据结构：队列
     */
    public void levelOrderTraversal(TreeNode root) {
        System.out.println("广度优先遍历");
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        ArrayDeque<TreeNode> queue = new ArrayDeque();
        queue.add(root);
        while (queue.isEmpty() == false) {
            TreeNode node = queue.remove();
            System.out.print(node.getVal() + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.print("\n");
    }
}
