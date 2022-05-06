package leetcode.editor.cn;

//给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "bcabc"
//输出："abc"
// 
//
// 示例 2： 
//
// 
//输入：s = "cbacdcbc"
//输出："acdb" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 由小写英文字母组成 
// 
//
// 
//
// 注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-
//distinct-characters 相同 
// Related Topics 栈 贪心 字符串 单调栈 👍 721 👎 0

import java.util.*;

public class RemoveDuplicateLetters{
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateLetters().new Solution();
        System.out.println(solution.removeDuplicateLetters("cbacdcbc"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int[] index = new int[26];
        boolean[] visited = new boolean[26];
        for(int i = 0; i < n; i++){
            index[chars[i] - 'a'] = i;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            if(visited[chars[i] - 'a']){
                continue;
            }
            while (!stack.isEmpty() && stack.peekLast() > chars[i] && index[stack.peekLast() - 'a'] > i){
                char temp = stack.removeLast();
                visited[temp - 'a'] = false;
            }
            stack.addLast(chars[i]);
            visited[chars[i] - 'a'] = true;
        }
        StringBuilder builder = new StringBuilder();
        for(char c : stack){
            builder.append(c);
        }
        return builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}