package leetcode.editor.cn;

//给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。 
//
// 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "hello"
//输出："holle"
// 
//
// 示例 2： 
//
// 
//输入：s = "leetcode"
//输出："leotcede" 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由 可打印的 ASCII 字符组成 
// 
// Related Topics 双指针 字符串 👍 248 👎 0

public class ReverseVowelsOfAString{
    public static void main(String[] args) {
        Solution solution = new ReverseVowelsOfAString().new Solution();
        System.out.println(solution.reverseVowels("aA"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = s.length() - 1;
        while (left < right){
            if(is_yuan(chars[left]) && is_yuan(chars[right])){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }
            if(!is_yuan(chars[left])){
                left++;
            }
            if(!is_yuan(chars[right])){
                right--;
            }
        }
        return String.valueOf(chars);
    }

    public boolean is_yuan(char c){
        if(c == 'a' || c == 'A' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||c == 'E' || c == 'I' || c == 'O' || c == 'U'){
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}