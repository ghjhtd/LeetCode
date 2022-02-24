package leetcode.editor.cn;

//给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面
//的字符构成。如果可以构成，返回 true ；否则返回 false。 
//
// (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。) 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 你可以假设两个字符串均只含有小写字母。 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 181 👎 0

import java.util.HashMap;
import java.util.Map;

public class 赎金信{
	public static void main(String[] args) {
		Solution solution = new 赎金信().new Solution();
		String s1 = "a";
		String s2 = "b";
		System.out.println(solution.canConstruct(s1,s2));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character,Integer> ran = new HashMap<Character,Integer>();
		Map<Character,Integer> mag = new HashMap<Character,Integer>();
		for(char s:ransomNote.toCharArray()){
			ran.put(s,ran.getOrDefault(s,0) + 1);
		}
		for(char r:magazine.toCharArray()){
			mag.put(r,mag.getOrDefault(r,0) + 1);
		}
		for(char s:ran.keySet()){
			if(!mag.containsKey(s) || mag.get(s) < ran.get(s))
				return false;
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}