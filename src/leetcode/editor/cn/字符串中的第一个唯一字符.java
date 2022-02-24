package leetcode.editor.cn;

//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 440 👎 0

import java.util.HashMap;
import java.util.Map;

public class 字符串中的第一个唯一字符{
	public static void main(String[] args) {
		Solution solution = new 字符串中的第一个唯一字符().new Solution();
		String test = "aabb";
		System.out.println(solution.firstUniqChar(test));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
		Map<Character,Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			map.put(s.charAt(i),map.getOrDefault(s.charAt(i), 0) + 1);
		}
		for(int i = 0; i < s.length(); i++){
			if(map.get(s.charAt(i)) == 1)
				return i;
		}
		return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}