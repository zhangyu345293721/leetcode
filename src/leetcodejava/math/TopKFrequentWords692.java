package leetcodejava.math;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: zhangyu
 * @date: 2021/6/11
 */
public class TopKFrequentWords692 {


    /**
     * 统计出现词频高的单词
     *
     * @param words 单词表
     * @param k     频率高的k个数
     * @return list
     */
    public List<String> topKFrequent(String[] words, int k) {
        if (words == null || words.length < 1) {
            return new ArrayList<>();
        }
        // List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        return map.entrySet().stream().sorted((o1, o2) -> {
            if (!o2.getKey().equals(o1.getKey())) {
                return o1.getValue() - o2.getValue();
            } else {
                return o1.getKey().compareTo(o2.getKey());
            }
        }).limit(k).map(e -> e.getKey()).collect(Collectors.toList());
    }
}
