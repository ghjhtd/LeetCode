package leetcode.editor.cn;

//给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。 
//
// 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。 
//
// 
//
// 示例1: 
//
// 
//输入: pattern = "abba", str = "dog cat cat dog"
//输出: true 
//
// 示例 2: 
//
// 
//输入:pattern = "abba", str = "dog cat cat fish"
//输出: false 
//
// 示例 3: 
//
// 
//输入: pattern = "aaaa", str = "dog cat cat dog"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= pattern.length <= 300 
// pattern 只包含小写英文字母 
// 1 <= s.length <= 3000 
// s 只包含小写英文字母和 ' ' 
// s 不包含 任何前导或尾随对空格 
// s 中每个单词都被 单个空格 分隔 
// 
// Related Topics 哈希表 字符串 👍 445 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordPattern{
    public static void main(String[] args) {
        Solution solution = new WordPattern().new Solution();
        System.out.println(solution.wordPattern("abba", "dog cat cat dog"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] ss = s.split(" ");
        if(pattern.length() != ss.length){
            return false;
        }
        Map<Character, ArrayList> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();
        for(String s1 : ss){
            map1.put(s1, map1.containsKey(s1)?map1.get(s1) + 1:1);
        }
        List list ;
        for(int i = 0; i < pattern.length(); i++){
            if(map.containsKey(pattern.charAt(i))){
                list = map.get(pattern.charAt(i));
                list.add(i);
            }else {
                list = new ArrayList();
                list.add(i);
            }
            map.put(pattern.charAt(i), (ArrayList) list);
        }
        if(map.size() != map1.size()){
            return false;
        }
        String first;
        for(List list1 : map.values()){
            first = ss[(int) list1.get(0)];
            for(Object i : list1){
                if(!ss[(int) i].equals(first)){
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}