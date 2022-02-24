package leetcode.editor.cn;

//给定一个单词，你需要判断单词的大写使用是否正确。 
//
// 我们定义，在以下情况时，单词的大写用法是正确的： 
//
// 
// 全部字母都是大写，比如"USA"。 
// 单词中所有字母都不是大写，比如"leetcode"。 
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。 
// 
//
// 否则，我们定义这个单词没有正确使用大写字母。 
//
// 示例 1: 
//
// 
//输入: "USA"
//输出: True
// 
//
// 示例 2: 
//
// 
//输入: "FlaG"
//输出: False
// 
//
// 注意: 输入是由大写和小写拉丁字母组成的非空单词。 
// Related Topics 字符串 
// 👍 140 👎 0

public class 检测大写字母{
	public static void main(String[] args) {
		Solution solution = new 检测大写字母().new Solution();
		String str = "G";
		System.out.println(solution.detectCapitalUse(str));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean detectCapitalUse(String word) {
		char which = 0;
		char first = word.charAt(0);
		if(word.length() == 1)
			return true;
		char second = word.charAt(1);
		if(first >= 'A' && first <= 'Z'){
			if(second >= 'A' && second <= 'Z'){
				which = 2;
			}
			if(second >='a' && second <= 'z'){
				which = 3;
			}
		}
		else
			which = 1;
		switch (which){
			case 1:
				for(int i = 0; i < word.length(); i++){
					if(word.charAt(i) < 'a' || word.charAt(i) > 'z')
						return false;
				}
				return true;

			case 2:
				for(int i = 0; i < word.length(); i++){
					if(word.charAt(i) < 'A' || word.charAt(i) > 'Z')
						return false;
				}
				return true;

			case 3:
				for(int i = 1; i < word.length(); i++){
					if(word.charAt(i) >= 'A' && word.charAt(i) <= 'Z')
						return false;
				}
				return true;

			default:
				return false;
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}