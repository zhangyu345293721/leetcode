package leetcodejava.top100likedquestions;

/**
 * 二维数组查找
 *
 * @author: zhangyu
 */
public class Search2D240 {
    /**
     * 输入数据，找出目标值
     *
     * @param matrix 二维数组
     * @param target 目标值
     * @return 布尔值
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        if (row == 0) return false;
        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (matrix[i][j] == target)
                return true;
            else if (matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
