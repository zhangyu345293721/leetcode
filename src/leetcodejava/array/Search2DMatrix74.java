package leetcodejava.array;

import org.junit.Assert;
import org.junit.Test;

/**
 * This is the solution of No.74 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/add-digits/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 *
 * 提示：
 *
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/search-a-2d-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class Search2DMatrix74 {

    @Test
    public void searchMatrixTest() {
        int matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target = 13;
        int result = searchMatrix(matrix, target);
        Assert.assertEquals(result, true);
    }
  
    /**
    * 查找矩阵中元素数值大小
    */
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n * m - 1;
        while(i <= j) {
            int mid = (j - i) / 2 + i;
            int value = matrix[mid / n][mid % n];
            if(value < target) {
                i = mid + 1;
            } else if (value > target) {
                j = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
