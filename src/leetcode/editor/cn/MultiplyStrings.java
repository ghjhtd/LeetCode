package leetcode.editor.cn;

//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
// Related Topics 数学 字符串 模拟 👍 846 👎 0

public class MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        System.out.println(solution.multiply("111","2"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        String Long_num = num2, Short_num = num1;
        String buffer = "0";
        if(num1.length() > num2.length()){
            Long_num = num1;
            Short_num = num2;
        }
        for(int i = 0; i < Short_num.length(); i++){
            buffer = add(buffer.toString(), mul_one(Long_num, Short_num.charAt(Short_num.length()-1-i) + ""));
            Long_num += "0";
        }
        return buffer.toString();
    }
    public String add(String num1, String num2){
        StringBuilder buffer = new StringBuilder();
        int count = 0;
        int a = 0, b = 0;
        for(int i = 0; i < num1.length() || i < num2.length() || count > 0; i++){
            a = i < num1.length() ? num1.charAt(num1.length()-1-i) - '0' : 0;
            b = i < num2.length() ? num2.charAt(num2.length()-1-i) - '0' : 0;
            buffer.append((a + b + count)%10 + "");
            count = (a + b + count)/10;
        }
        return buffer.reverse().toString();
    }

    public String mul_one(String num, String one){
        StringBuilder builder = new StringBuilder();
        int count = 0;
        int a = 0, b = one.charAt(0) - '0';
        for(int i = 0; i < num.length() || count > 0; i++){
            a = i < num.length() ? num.charAt(num.length() - 1 - i) - '0' : 0;
            builder.append((a*b + count)%10 + "");
            count = (a*b + count)/10;
        }
        return builder.reverse().toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}