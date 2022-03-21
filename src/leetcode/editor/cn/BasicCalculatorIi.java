package leetcode.editor.cn;

//给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。 
//
// 整数除法仅保留整数部分。 
//
// 你可以假设给定的表达式总是有效的。所有中间结果将在 [-2³¹, 2³¹ - 1] 的范围内。 
//
// 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "3+2*2"
//输出：7
// 
//
// 示例 2： 
//
// 
//输入：s = " 3/2 "
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：s = " 3+5 / 2 "
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 3 * 10⁵ 
// s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开 
// s 表示一个 有效表达式 
// 表达式中的所有整数都是非负整数，且在范围 [0, 2³¹ - 1] 内 
// 题目数据保证答案是一个 32-bit 整数 
// 
// Related Topics 栈 数学 字符串 👍 542 👎 0

public class BasicCalculatorIi{
    public static void main(String[] args) {
        Solution solution = new BasicCalculatorIi().new Solution();
        StringBuilder builder = new StringBuilder("3+ 2 * 2 ");
        System.out.println(solution.calculate("2*3*4"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int calculate(String s) {

        StringBuilder builder = new StringBuilder(s);
        for(int i = 0; i < builder.length(); i++){
            if(builder.charAt(i) == '/' || builder.charAt(i) == '*'){
                i = replace(builder, i);
            }
        }
        String[] nums = builder.toString().replace("-", "+-").split("\\+");
        int count = 0;
        for(String ss : nums){
            count += Integer.parseInt(ss.trim());
        }
        return count;
    }

    public int replace(StringBuilder builder, int index){
        int left = index-1, right = index+1;
        while (left >= 0 && builder.charAt(left) != '+' && builder.charAt(left) != '-'&& builder.charAt(left) != '*' && builder.charAt(left) != '/'){
            left --;
        }
        while (right < builder.length() && builder.charAt(right) != '+' && builder.charAt(right) != '-'&& builder.charAt(right) != '*' && builder.charAt(right) != '/'){
            right ++;
        }
        int a = Integer.parseInt(builder.substring(left + 1, index).trim());
        int b = Integer.parseInt(builder.substring(index + 1, right).trim());
        if(builder.charAt(index) == '*'){
            builder.replace(left + 1, right,a*b+"");
        }
        else {
            builder.replace(left + 1, right,a/b+"");
        }
        return left;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}