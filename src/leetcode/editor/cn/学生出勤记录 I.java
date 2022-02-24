package leetcode.editor.cn;

//给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）。记录中只含下面三种字符： 
//
// 
// 'A'：Absent，缺勤 
// 'L'：Late，迟到 
// 'P'：Present，到场 
// 
//
// 如果学生能够 同时 满足下面两个条件，则可以获得出勤奖励： 
//
// 
// 按 总出勤 计，学生缺勤（'A'）严格 少于两天。 
// 学生 不会 存在 连续 3 天或 连续 3 天以上的迟到（'L'）记录。 
// 
//
// 如果学生可以获得出勤奖励，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "PPALLP"
//输出：true
//解释：学生缺勤次数少于 2 次，且不存在 3 天或以上的连续迟到记录。
// 
//
// 示例 2： 
//
// 
//输入：s = "PPALLL"
//输出：false
//解释：学生最后三天连续迟到，所以不满足出勤奖励的条件。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s[i] 为 'A'、'L' 或 'P' 
// 
// Related Topics 字符串 
// 👍 118 👎 0

class 学生出勤记录{
	public static void main(String[] args) {
		Solution solution = new 学生出勤记录().new Solution();
		String s = "PPALLL";
		System.out.println(solution.checkRecord(s));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkRecord(String s) {
		int later = 0, max_later = Integer.MIN_VALUE;
		int count_A = 0;
		char last_char = ' ';
		for(char chars: s.toCharArray()){
			if(chars == 'A')
				count_A += 1;
			if(chars == 'L' && last_char == 'L'){
				later ++;
				if(later > max_later)
					max_later = later;
			}
			else {
				later = 0;
			}
			last_char = chars;
		}
		return count_A < 2 && max_later < 2;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}