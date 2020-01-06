package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: zhangyu
 */
public class SelectDemo {
    /**
     * 排列选择（从列表中选择n个排列）
     *
     * @param dataList 待选列表
     * @param n        选择个数
     */
    public static void arrangementSelect(String[] dataList, int n, List<List<String>> list) {
        arrangementSelect(dataList, new String[n], 0, list);
    }

    /**
     * 排列选择
     *
     * @param dataList    待选列表
     * @param resultList  前面（resultIndex-1）个的排列结果
     * @param resultIndex 选择索引，从0开始
     */
    private static void arrangementSelect(String[] dataList, String[] resultList, int resultIndex, List<List<String>> list) {
        int resultLen = resultList.length;
        if (resultIndex >= resultLen) { // 全部选择完时，输出排列结果
            list.add(Arrays.asList(resultList));
            return;
        }
        // 递归选择下一个
        for (int i = 0; i < dataList.length; i++) {
            // 判断待选项是否存在于排列结果中
            boolean exists = false;
            for (int j = 0; j < resultIndex; j++) {
                if (dataList[i].equals(resultList[j])) {
                    exists = true;
                    break;
                }
            }
            if (!exists) { // 排列结果不存在该项，才可选择
                resultList[resultIndex] = dataList[i];
                arrangementSelect(dataList, resultList, resultIndex + 1, list);
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        String[] dataList = {"a1", "a2", "a3", "a4", "a5"};
        int n = 5;
        List<List<String>> list = new ArrayList<>();
        arrangementSelect(dataList, n, list);
        System.out.println(list.size());
        long endTime = System.currentTimeMillis();
        System.out.println(list);
        System.out.println(endTime - startTime);
    }
}
