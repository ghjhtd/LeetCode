package leetcode.editor.cn;

//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1775 👎 0

public class 最长公共前缀{
	public static void main(String[] args) {
		Solution solution = new 最长公共前缀().new Solution();
		String[] str = new String[]{"flower","flow","flight"};
		System.out.println(solution.longestCommonPrefix(str));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
		String str = strs[0];
		String res = "";
		for(String s : strs){
			res = "";
			for(int i = 0; i < Math.min(s.length(),str.length()); i++){
				if(s.charAt(i) == str.charAt(i) )
					res += s.charAt(i);
				else
					break;
			}
			str = res;
		}
		return str;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}