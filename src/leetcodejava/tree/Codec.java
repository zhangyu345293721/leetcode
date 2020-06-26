package leetcodejava.tree;

import org.junit.Test;

/**
 * @author: zhangyu
 * @date: 2020/06/16 21:45
 */
public class Codec {

    @Test
    public void codeTest(){
        String decode="[1,2,3,null,null,4,5]";
        TreeNode deserialize = deserialize(decode);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return "Hello";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        data=data.substring(1,data.length()-1);
        String [] strs=data.split(",");
        Integer[] arr=new Integer[strs.length];
        for(int i=0;i< strs.length;i++){
            if(!strs[i].equals("null")){
                arr[i]=Integer.valueOf(strs[i]);
            }
        }
        TreeNode binaryTreeByArray = TreeNode.createBinaryTreeByArray(arr, 0);
        return binaryTreeByArray;
    }
}
