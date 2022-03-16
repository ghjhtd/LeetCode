package leetcode.editor.cn;

//给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 10⁹ 
// 
// Related Topics 递归 数学 动态规划 👍 400 👎 0

public class NumberOfDigitOne{
    public static void main(String[] args) {
        Solution solution = new NumberOfDigitOne().new Solution();
        System.out.println(solution.countDigitOne(0));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigitOne(int n) {
        long mulk = 1;
        int ans = 0;
        for (int k = 0; n >= mulk; ++k) {
            ans += (n / (mulk * 10)) * mulk + Math.min(Math.max(n % (mulk * 10) - mulk + 1, 0), mulk);
            mulk *= 10;
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}