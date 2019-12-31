package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class MaximumDepthTree {

    @Test
    public void fun() {

    }

    public int maximumDepthTree(Tree t) {
        if (t == null) {
            return 0;
        }
        int left = maximumDepthTree(t.left);
        int right = maximumDepthTree(t.right);
        return Math.max(left, right) + 1;
    }
}

class Tree {
    Tree right;
    Tree left;
    int next;

    public Tree(int x) {
        this.next = x;
    }
}