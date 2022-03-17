package leetcode.editor.cn;

//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 896 👎 0

public class PowxN{
    public static void main(String[] args) {
        Solution solution = new PowxN().new Solution();
        System.out.println(solution.myPow(2.0, -2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        double count = 1.0;
        for(int i = 0; i < Math.abs(n); i++){
            count *= x;
        }
        if(n < 0){
            return 1.0/count;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}