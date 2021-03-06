package leetcode.editor.cn;

//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯 👍 173 👎 0

public class CountNumbersWithUniqueDigits{
    public static void main(String[] args) {
        Solution solution = new CountNumbersWithUniqueDigits().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
     int[] fn;
     {
        fn = new int[9];
        fn[0] = 1;
        fn[1] = 10;
        int g = 9;
        int f = 9;
        for (int i = 2; i < 9; i++) {
            f = f * g;
            fn[i] = fn[i - 1] + f;
            g = g - 1;
        }
    }

    public int countNumbersWithUniqueDigits(int n) {
        return fn[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}