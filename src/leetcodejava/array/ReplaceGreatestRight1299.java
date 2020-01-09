package leetcodejava.array;

import org.junit.Test;

/**
 * 数组右边最大值代替它，如果到最后就赋值为-1
 *
 * @author: zhangyu
 */
public class ReplaceGreatestRight1299 {
    @Test
    public void replaceGreatestRight() {
        int[] arr = {17, 18, 5, 4, 6, 1};
        int[] resultArr = replaceElements(arr);

        for (int i : resultArr) {
            System.out.print(i + " ");
        }
    }

    /**
     * 取代数组
     *
     * @param arr 输入数组
     * @return 新数组
     */
    public int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int leftMax = getLeftMax(arr, i + 1);
            arr[i] = leftMax;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    /**
     * 求剩余数组中最大值
     *
     * @param arr 数组
     * @param i   下标
     * @return 最大值
     */
    private int getLeftMax(int[] arr, int i) {
        int max = Integer.MIN_VALUE;
        for (int j = i; j < arr.length; j++) {
            if (arr[j] > max) {
                max = arr[j];
            }
        }
        return max;
    }
}
