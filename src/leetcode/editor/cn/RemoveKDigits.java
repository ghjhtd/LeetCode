package leetcode.editor.cn;

//给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。 
// 
//
// 示例 1 ： 
//
// 
//输入：num = "1432219", k = 3
//输出："1219"
//解释：移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219 。
// 
//
// 示例 2 ： 
//
// 
//输入：num = "10200", k = 1
//输出："200"
//解释：移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
// 
//
// 示例 3 ： 
//
// 
//输入：num = "10", k = 2
//输出："0"
//解释：从原数字移除所有的数字，剩余为空就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= num.length <= 10⁵ 
// num 仅由若干位数字（0 - 9）组成 
// 除了 0 本身之外，num 不含任何前导零 
// 
// Related Topics 栈 贪心 字符串 单调栈 👍 785 👎 0

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits{
    public static void main(String[] args) {
        Solution solution = new RemoveKDigits().new Solution();
        System.out.println(solution.removeKdigits("1432219",3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeKdigits(String num, int k) {
        if(k >= num.length()){
            return 0 + "";
        }
        Deque<Character> stack = new ArrayDeque<>();
        int remove_Count = 0;
        for(int i = 0; i < num.length(); i++){
            while (remove_Count < k && !stack.isEmpty() && num.charAt(i) < stack.peekLast()){
                stack.removeLast();
                remove_Count++;
            }
            stack.addLast(num.charAt(i));
        }
        while (remove_Count < k){
            stack.removeLast();
            remove_Count++;
        }
        StringBuilder builder = new StringBuilder();
        boolean is_begin = false;
        for(char c : stack){
            if(c != '0'){
                is_begin = true;
            }
            if(is_begin){
                builder.append(c);
            }
        }
        return builder.length() == 0 ? "0" : builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}