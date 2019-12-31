package leetcode;

import org.junit.Test;

/**
 * @author zhangyu
 **/


public class MaxRectangle {
    @Test
    public void fun() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        int max = maximalRectangle(matrix);
        System.out.println(max);
    }

    private int maximalRectangle(char[][] matrix) {
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){

            }
        }
        return max;
    }
    private boolean isRectangle(char[][] rectangle){
        for(int i=0;i<rectangle.length;i++){
            for(int j=0;j<rectangle[0].length;j++){
                if(rectangle[i][j]=='0'){
                    return false;
                }
            }
        }
        return true;
    }
}
