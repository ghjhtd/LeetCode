package leetcode.editor.cn;

//给定一个字符串 s 和一些 长度相同 的单词 words 。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。 
//
// 注意子串要与 words 中的单词完全匹配，中间不能有其他字符 ，但不需要考虑 words 中单词串联的顺序。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "barfoothefoobarman", words = ["foo","bar"]
//输出：[0,9]
//解释：
//从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
//输出的顺序不重要, [9,0] 也是有效答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
//输出：[6,9,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 30 
// words[i] 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 657 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords{
    public static void main(String[] args) {
        Solution solution = new SubstringWithConcatenationOfAllWords().new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","good"}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for(String ss : words){
            map.put(ss, map.getOrDefault(ss, 0) + 1);
        }
        Map<String, Integer> temp_map = mapClone(map);
        int k = words[0].length();
        int n = s.length();
        int prei = 0;
        for (int i = 0; i < n - k * words.length + 1; i++) {
            String temp = s.substring(i, i + k);
            if(temp_map.containsKey(temp)){
                prei = i;
                while (temp_map.size() != 0 && i < n){
                    temp = s.substring(i, i + k);
                    if(!temp_map.containsKey(temp)){
                        break;
                    }
                    temp_map.put(temp, temp_map.get(temp) - 1);
                    if(temp_map.get(temp) == 0){
                        temp_map.remove(temp);
                    }
                    i += k;
                }
                if(temp_map.size() == 0){
                    list.add(i - k * words.length);
                }
                i = prei;
                temp_map = mapClone(map);
            }
        }
        return list;
    }

    public Map<String, Integer> mapClone(Map<String, Integer> map){
        Map<String, Integer> temp_map = new HashMap<>();
        for(String key : map.keySet()){
            temp_map.put(key, map.get(key));
        }
        return temp_map;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}