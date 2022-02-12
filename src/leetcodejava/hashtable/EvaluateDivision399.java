package leetcodejava.hashtable;

import org.junit.Test;

import java.util.*;

/**
 * This is the solution of No.399 problem in the LeetCode,
 * the website of the problem is as follow:
 * https://leetcode-cn.com/problems/evaluate-division/
 * <p>
 * The description of problem is as follow:
 * ==========================================================================================================
 * 统计所有小于非负整数 n 的质数的数量。
 * <p>
 * 示例:
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * * ==========================================================================================================
 *
 * @author zhangyu (zhangyuyu417@gmail.com)
 */
public class EvaluateDivision399 {

    @Test
    public void evaluateDivisionTest() {
        List<String> list1 = new ArrayList<>(Arrays.asList("a", "b"));
        List<String> list2 = new ArrayList<>(Arrays.asList("b", "c"));
        List<List<String>> equations = new ArrayList(Arrays.asList(list1, list2));
        double[] values = {2.0, 3.0};
        List<String> list3 = new ArrayList<>(Arrays.asList("a", "c"));
        List<String> list4 = new ArrayList<>(Arrays.asList("b", "a"));
        List<String> list5 = new ArrayList<>(Arrays.asList("a", "e"));
        List<String> list6 = new ArrayList<>(Arrays.asList("a", "a"));
        List<String> list7 = new ArrayList<>(Arrays.asList("x", "x"));
        List<List<String>> queries = new ArrayList<>(Arrays.asList(list3, list4, list5, list6, list7));
        double[] equation = calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(equation));
    }

    Map<String, Map<String, Double>> varToVarToVal = new HashMap<>();

    /**
     * @param equations 数字
     * @param values    结果值
     * @param queries   查询结果
     * @return value值
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int i = 0;
        for (List<String> equation : equations) {
            putEquation(equation.get(0), equation.get(1), values[i]);
            putEquation(equation.get(1), equation.get(0), 1 / values[i]);
            i++;
        }
        double[] res = new double[queries.size()];
        int j = 0;
        for (List<String> query : queries) {
            res[j++] = getEquation(query.get(0), query.get(1), new HashSet() {
                {
                    add(query.get(0));
                }
            });
        }
        return res;
    }

    /**
     * @param var1  值1
     * @param var2  值2
     * @param value 返回值
     */
    private void putEquation(String var1, String var2, double value) {
        Map<String, Double> varToVal = varToVarToVal.getOrDefault(var1, new HashMap<>());
        varToVal.put(var2, value);
        varToVarToVal.putIfAbsent(var1, varToVal);
    }

    /**
     * @param var1 值1
     * @param var2 值2
     * @param vis  集合
     * @return double值
     */
    private double getEquation(String var1, String var2, Set<String> vis) {
        Map<String, Double> varToVal = varToVarToVal.get(var1);
        if (varToVal == null) return -1.0;
        if (varToVal.containsKey(var2)) {
            return varToVal.get(var2);
        } else {
            for (String var : varToVal.keySet()) {
                if (!vis.contains(var)) {
                    vis.add(var);
                    double tmp = getEquation(var, var2, vis);
                    if (tmp != -1.0) {
                        return varToVal.get(var) * tmp;
                    }
                }
            }
            return -1.0;
        }
    }
}
