package leetcode.editor.cn;

//给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 100
//输出: "202"
// 
//
// 示例 2: 
//
// 
//输入: num = -7
//输出: "-10"
// 
//
// 
//
// 提示： 
//
// 
// -10⁷ <= num <= 10⁷ 
// 
// Related Topics 数学 👍 173 👎 0

public class Base7{
    public static void main(String[] args) {
        Solution solution = new Base7().new Solution();
        System.out.println(solution.convertToBase7(-14));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String convertToBase7(int num) {
        StringBuilder builder = new StringBuilder();
        int n = Math.abs(num);
        while(n / 7 > 0){
            builder.append(n % 7);
            n /= 7;
        }
        builder.append(n);
        if(num < 0){
            return "-" + builder.reverse().toString();
        }
        return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}