package leetcode.editor.cn;

//编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。 
//
// 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。 
//
// 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。 
//
// 
//
// 示例 1： 
//
// 输入：["h","e","l","l","o"]
//输出：["o","l","l","e","h"]
// 
//
// 示例 2： 
//
// 输入：["H","a","n","n","a","h"]
//输出：["h","a","n","n","a","H"] 
// Related Topics 递归 双指针 字符串 
// 👍 455 👎 0

public class 反转字符串{
	public static void main(String[] args) {
		Solution solution = new 反转字符串().new Solution();
		char[] test = {'h','e','l','l','o'};
		solution.reverseString(test);
		System.out.println(test);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void reverseString(char[] s) {
    	char temp = ' ';
    	for(int i = 0; i < s.length - i - 1; i++){
    		temp = s[i];
    		s[i] = s[s.length - i - 1];
    		s[s.length - i - 1] = temp;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}