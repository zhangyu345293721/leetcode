package leetcode.question.traversebinarytree;

/**
 * @author: zhangyu
 */
public class BinaryTreeNode {
    private BinaryTreeNode leftNode;
    private BinaryTreeNode rightNode;
    protected int data;

    public BinaryTreeNode(int data){
        this.data = data;
    }

    public BinaryTreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(BinaryTreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public BinaryTreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(BinaryTreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
