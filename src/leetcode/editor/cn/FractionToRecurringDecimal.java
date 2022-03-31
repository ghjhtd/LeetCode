package leetcode.editor.cn;

//给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。 
//
// 如果小数部分为循环小数，则将循环的部分括在括号内。 
//
// 如果存在多个答案，只需返回 任意一个 。 
//
// 对于所有给定的输入，保证 答案字符串的长度小于 10⁴ 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numerator = 1, denominator = 2
//输出："0.5"
// 
//
// 示例 2： 
//
// 
//输入：numerator = 2, denominator = 1
//输出："2"
// 
//
// 示例 3： 
//
// 
//输入：numerator = 4, denominator = 333
//输出："0.(012)"
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= numerator, denominator <= 2³¹ - 1 
// denominator != 0 
// 
// Related Topics 哈希表 数学 字符串 👍 371 👎 0

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal{
    public static void main(String[] args) {
        Solution solution = new FractionToRecurringDecimal().new Solution();
        System.out.println(solution.fractionToDecimal(-1,-2147483648));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0){
            return 0 + "";
        }
        Long numera = (long)numerator;
        Long denomina = (long)denominator;
        StringBuilder integer = new StringBuilder();
        StringBuilder builder = new StringBuilder();
        Map<Long, Integer> map = new HashMap<>();
        if(numera < 0 ^ denomina < 0){
            integer.append("-");
        }
        numera = Math.abs(numera);
        denomina = Math.abs(denomina);
        integer.append(numera/denomina + "");
        numera %= denomina;
        if(numera == 0){
            return integer.toString();
        }
        integer.append(".");
        long temp = 0;
        int i = 0;
        while (numera != 0 && !map.containsKey(numera)){
            map.put(numera, i);
            numera *= 10;
            temp = (numera/denomina);
            builder.append(temp + "");
            numera %= denomina;
            i++;
        }
        if(numera != 0){
            builder.insert(map.get(numera), "(");
            builder.append(")");
        }
        return integer.toString() + builder.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}