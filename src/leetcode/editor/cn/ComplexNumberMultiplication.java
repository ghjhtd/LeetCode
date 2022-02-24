package leetcode.editor.cn;

//复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件： 
//
// 
// 实部 是一个整数，取值范围是 [-100, 100] 
// 虚部 也是一个整数，取值范围是 [-100, 100] 
// i² == -1 
// 
//
// 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：num1 = "1+1i", num2 = "1+1i"
//输出："0+2i"
//解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
// 
//
// 示例 2： 
//
// 
//输入：num1 = "1+-1i", num2 = "1+-1i"
//输出："0+-2i"
//解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。 
// 
//
// 
//
// 提示： 
//
// 
// num1 和 num2 都是有效的复数表示。 
// 
// Related Topics 数学 字符串 模拟 👍 70 👎 0

public class ComplexNumberMultiplication{
    public static void main(String[] args) {
        Solution solution = new ComplexNumberMultiplication().new Solution();
        System.out.println(solution.complexNumberMultiply("1+-1i", "1+-1i"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int[] nums1 = {0, 0};
        int[] nums2 = {0, 0};
        int[] result = {0, 0};
        nums1[0] = Integer.parseInt(num1.split("\\+")[0]);
        nums1[1] = Integer.parseInt(num1.split("\\+")[1].split("i")[0]);
        nums2[0] = Integer.parseInt(num2.split("\\+")[0]);
        nums2[1] = Integer.parseInt(num2.split("\\+")[1].split("i")[0]);

        result[0] = nums1[0]*nums2[0] - nums1[1]*nums2[1];
        result[1] = nums1[0]*nums2[1] + nums1[1]*nums2[0];
        return result[0] + "+" + result[1] + "i";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}