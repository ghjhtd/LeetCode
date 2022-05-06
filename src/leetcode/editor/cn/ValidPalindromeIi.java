package leetcode.editor.cn;

//给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "aba"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "abca"
//输出: true
//解释: 你可以删除c字符。
// 
//
// 示例 3: 
//
// 
//输入: s = "abc"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 10⁵ 
// s 由小写英文字母组成 
// 
// Related Topics 贪心 双指针 字符串 👍 491 👎 0

public class ValidPalindromeIi{
    public static void main(String[] args) {
        Solution solution = new ValidPalindromeIi().new Solution();
        System.out.println(solution.validPalindrome("abc"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right){
            if(s.charAt(left) != s.charAt(right)){
                return (is_hui(s, left, right - 1) || is_hui(s, left + 1, right));
            }else{
                left++;
                right--;
            }

        }
        return true;
    }

    public boolean is_hui(String s, int left, int right){
        for(int i = 0; i <= (right - left)/2; i++){
            if(s.charAt(left + i) != s.charAt(right - i)){
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}