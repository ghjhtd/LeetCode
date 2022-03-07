package leetcode.editor.cn;

//给定两个字符串 a 和 b，寻找重复叠加字符串 a 的最小次数，使得字符串 b 成为叠加后的字符串 a 的子串，如果不存在则返回 -1。 
//
// 注意：字符串 "abc" 重复叠加 0 次是 ""，重复叠加 1 次是 "abc"，重复叠加 2 次是 "abcabc"。 
//
// 
//
// 示例 1： 
//
// 输入：a = "abcd", b = "cdabcdab"
//输出：3
//解释：a 重复叠加三遍后为 "abcdabcdabcd", 此时 b 是其子串。
// 
//
// 示例 2： 
//
// 输入：a = "a", b = "aa"
//输出：2
// 
//
// 示例 3： 
//
// 输入：a = "a", b = "a"
//输出：1
// 
//
// 示例 4： 
//

// 输入：a = "abc", b = "wxyz"
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= a.length <= 10⁴ 
// 1 <= b.length <= 10⁴ 
// a 和 b 由小写英文字母组成 
// 
// Related Topics 字符串 字符串匹配 👍 263 👎 0

public class RepeatedStringMatch{
    public static void main(String[] args) {
        Solution solution = new RepeatedStringMatch().new Solution();
        System.out.println(solution.repeatedStringMatch("aaac","aac"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 0;
        int index = 0;
        int temp_index = 0;
        for(int i = 0; i <a.length(); i++){
            if(a.charAt(i) == b.charAt(index)){
                temp_index = i;
                while(a.charAt(temp_index % a.length()) == b.charAt(index++)){
                    if(index == b.length()){
                        return temp_index / a.length() +1;
                    }
                    temp_index++;
                }
                index = 0;
            }else{
                index = 0;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}