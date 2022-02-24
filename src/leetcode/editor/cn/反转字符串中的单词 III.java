package leetcode.editor.cn;

//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 330 👎 0

class 反转字符串中的单词III{
	public static void main(String[] args) {
		Solution solution = new 反转字符串中的单词III().new Solution();
		String test = "Let's take LeetCode contest";
		System.out.println(solution.reverseWords(test).toCharArray());
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
    	char[] chars = s.toCharArray();
    	int left = 0, right = 0;
    	for(int i = 0; i < chars.length; i++){
    		if(chars[i] != ' '){
    			left = i;
    			right = left;
    			while (right < chars.length - 1 && chars[right] != ' '){
					right++;
				}
				if(chars[right] == ' ')
					right--;
				chars = reverse(chars, left, right);
				i = right;
			}
		}
    	return new String(chars);
    }
    public char[] reverse(char[] chars, int left, int right){
    	int n = chars.length;
    	char temp = 0;
    	while (left < right){
    		temp = chars[left];
    		chars[left++] = chars[right];
    		chars[right--] = temp;
		}
		return chars;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}