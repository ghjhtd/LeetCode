package leetcode.editor.cn;

//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−2³¹, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= x <= 2³¹ - 1 
// 
// Related Topics 数学 👍 3422 👎 0

public class ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new ReverseInteger().new Solution();
        System.out.println(solution.reverse(32768));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        if(x == 0){
            return 0;
        }
        StringBuilder resoult = new StringBuilder();
        String s = Math.abs(x) + "";
        int res = 0;
        for(int i = 0; i < s.length(); i++){
            resoult.append(s.charAt(s.length() - 1 -i));
        }
        try {
            res = Integer.parseInt(resoult.toString());
        }catch (Exception e){
            return 0;
        }
        return x / Math.abs(x) * res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}