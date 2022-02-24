package leetcode.editor.cn;

//给定一个字符串 s，计算具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是连续的。 
//
// 重复出现的子串要计算它们出现的次数。 
//
// 
//
// 示例 1 : 
//
// 
//输入: "00110011"
//输出: 6
//解释: 有6个子串具有相同数量的连续1和0：“0011”，“01”，“1100”，“10”，“0011” 和 “01”。
//
//请注意，一些重复出现的子串要计算它们出现的次数。
//
//另外，“00110011”不是有效的子串，因为所有的0（和1）没有组合在一起。
// 
//
// 示例 2 : 
//
// 
//输入: "10101"
//输出: 4
//解释: 有4个子串：“10”，“01”，“10”，“01”，它们具有相同数量的连续1和0。
// 
//
// 
//
// 提示： 
//
// 
// s.length 在1到50,000之间。 
// s 只包含“0”或“1”字符。 
// 
// Related Topics 双指针 字符串 
// 👍 400 👎 0

import java.util.ArrayList;
import java.util.List;

public class 计数二进制子串{
	public static void main(String[] args) {
		Solution solution = new 计数二进制子串().new Solution();
		String s = "10101";
		System.out.println(solution.countBinarySubstrings(s));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBinarySubstrings(String s) {
    	List<Integer> list = new ArrayList<>();
    	int index = 0;
    	int count = 0;
    	int sum = 0;
		for(int i = 0; i < s.length(); ){
			char c = s.charAt(i);
			count = 0;
			while(i < s.length() && s.charAt(i) == c){
				count ++;
				i ++;
			}
			list.add(count);
		}
		for(int i = 0; i < list.size() - 1; i++){
			sum += Math.min(list.get(i), list.get(i + 1));
		}
		return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}