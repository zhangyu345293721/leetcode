package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 转换二维数组
 *
 * @author: zhangyu
 */
public class Shift2DGrid1260 {
    @Test
    public void testShift2DGrid() {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 1;
        List<List<Integer>> list = shiftGrid(grid, k);
        System.out.println(list);
    }

    /**
     * 旋转二维数组
     *
     * @param grid 二维数组
     * @param k    次数
     * @return 链表
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while(k>0){
            for(int i=0;i<grid.length;i++){
                for(int j=grid[0].length-1;j>0;j--){
                    int temp=grid[i][j];
                    grid[i][j]=grid[i][j-1];
                    grid[i][j-1]=temp;
                }
                if(i==grid.length-1){
                    while(i>0){
                        int temp=grid[i][0];
                        grid[i][0]=grid[i-1][0];
                        grid[i-1][0]=temp;
                        i--;
                    }
                    break;
                }
            }
            k--;
        }
        return new ArrayList(Arrays.asList(grid));
    }
}
