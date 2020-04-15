package leetcodejava.array;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 面试40:最小的k个数
 *
 * @author: zhangyu
 */
public class SolutionView40 {

    @Test
    public void testSolutionView() {
        int[] arr = {3, 4, 5, 6, 1, 3, 5, 6, 7, 9};
        int k = 3;
        int[] partition = getLeastNumbers3(arr, k);
        System.out.println(partition);
    }

    /**
     * 获取最小多个值;快速排序
     *
     * @param arr 数组
     * @param k   k个数
     * @return 数组
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return arr;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j + 1] < arr[j]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return Arrays.stream(arr).limit(k).toArray();
    }

    /**
     * 获取最小多个值,利用优先队列
     *
     * @param arr 数组
     * @param k   k个数
     * @return 数组
     */
    public int[] getLeastNumbers2(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            priorityQueue.add(num);
            if (priorityQueue.size() > arr.length - k) {
                list.add(priorityQueue.poll());
            }
        }
        return list.stream().mapToInt(e -> Integer.valueOf(e)).toArray();
    }

    /**
     * 获取最小多个值 ,利用快速排序方法
     *
     * @param arr 数组
     * @param k   k个数
     * @return 数组
     */
    public int[] getLeastNumbers3(int[] arr, int k) {
        int len = arr.length;
        if (k == 0 || k > len) {
            return new int[0];
        }
        int target = k - 1;
        int left = 0;
        int right = len - 1;
        while (true) {
            int index = partition(arr, left, right);
            if (index == target) {
                int[] res = new int[k];
                for (int i = 0; i < k; i++) {
                    res[i] = arr[i];
                }
                return res;
            } else if (index < target) {
                // 下一轮搜索区间在 [index + 1, right]
                left = index + 1;
            } else {
                // 下一轮搜索区间在 [left, index - 1]
                right = index - 1;
            }
        }
    }

    /**
     * 进行分区操作,是的左边小于阈值，右边大于等于阈值
     *
     * @param arr   数组
     * @param left  左边
     * @param right 右边
     * @return 下标
     */
    private int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int index = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < pivot) {
                index++;
                swap(arr, index, i);
            }
        }
        swap(arr, left, index);
        return index;
    }

    /**
     * 交换数据中元素的位置
     *
     * @param arr 数组
     * @param i   位置i
     * @param j   位置j
     */
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
