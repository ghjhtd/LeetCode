package leetcode.editor.cn;

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。 
//
// 
//
// 注意： 
//
// 
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。 
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
// 
//
// 示例 2： 
//
// 
//输入：s = "a", t = "a"
//输出："a"
// 
//
// 示例 3: 
//
// 
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, t.length <= 10⁵ 
// s 和 t 由英文字母组成 
// 
//
// 
//进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？ Related Topics 哈希表 字符串 滑动窗口 👍 1868 👎 0

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring{
    public static void main(String[] args) {
        Solution solution = new MinimumWindowSubstring().new Solution();
        System.out.println(solution.minWindow("ADOBECODEBANC", "ABC"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String minWindow(String s, String t) {
        int n_s = s.length();
        int n_t = t.length();
        if(n_s < n_t){
            return "";
        }
        int left = 0, right = 0;
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < n_t; i++) {
            tmap.put(t.charAt(i), tmap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int res_left = 0, res_right = n_s;
        int distance = 0;
        while (right < n_s){
            Character temp = s.charAt(right);
            smap.put(temp, smap.getOrDefault(temp, 0) +1);
            if(tmap.containsKey(temp) && smap.get(temp) <= tmap.get(temp)){
                distance++;
            }
            while (distance == n_t){
                temp = s.charAt(left);
                if(tmap.containsKey(temp) && tmap.get(temp).equals(smap.get(temp))){
                    distance--;
                }
                smap.put(temp, smap.getOrDefault(temp, 0) - 1);
                left++;
                if(right - left < res_right - res_left){
                    res_right = right;
                    res_left = left;
                }
            }
            right++;
        }
        if(res_right - res_left == n_s){
            return "";
        }
        return s.substring(res_left - 1, res_right + 1);
    }
}


//leetcode submit region end(Prohibit modification and deletion)

}