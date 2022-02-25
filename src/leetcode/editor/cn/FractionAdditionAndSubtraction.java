package leetcode.editor.cn;

//给定一个表示分数加减运算的字符串 expression ，你需要返回一个字符串形式的计算结果。 
//
// 这个结果应该是不可约分的分数，即最简分数。 如果最终结果是一个整数，例如 2，你需要将它转换成分数形式，其分母为 1。所以在上述例子中, 2 应该被转换为
// 2/1。 
//
// 
//
// 示例 1: 
//
// 
//输入: expression = "-1/2+1/2"
//输出: "0/1"
// 
//
// 示例 2: 
//
// 
//输入: expression = "-1/2+1/2+1/3"
//输出: "1/3"
// 
//
// 示例 3: 
//
// 
//输入: expression = "1/3-1/2"
//输出: "-1/6"
// 
//
// 
//
// 提示: 
//
// 
// 输入和输出字符串只包含 '0' 到 '9' 的数字，以及 '/', '+' 和 '-'。 
// 输入和输出分数格式均为 ±分子/分母。如果输入的第一个分数或者输出的分数是正数，则 '+' 会被省略掉。 
// 输入只包含合法的最简分数，每个分数的分子与分母的范围是 [1,10]。 如果分母是1，意味着这个分数实际上是一个整数。 
// 输入的分数个数范围是 [1,10]。 
// 最终结果的分子与分母保证是 32 位整数范围内的有效整数。 
// 
// Related Topics 数学 字符串 模拟 👍 60 👎 0

public class FractionAdditionAndSubtraction {
    public static void main(String[] args) {
        Solution solution = new FractionAdditionAndSubtraction().new Solution();
        System.out.println(solution.fractionAddition("-10/7+1/9+2/7+2/1-1/3+3/10-1/10+8/7-4/9-3/2"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String fractionAddition(String expression) {
            //字符串分割
            String[] exp = null;
            if (expression.charAt(0) == '-') {
                exp = expression.substring(1, expression.length()).split("\\+|\\-");
            } else {
                exp = expression.split("\\+|\\-");
            }
            //字符转数字
            int[][] nums = new int[exp.length][2];
            int[] common = {0, 1};
            int temp = 0;
            for (int i = 0; i < exp.length; i++) {
                nums[i][0] = Integer.parseInt(exp[i].split("/")[0]);
                nums[i][1] = Integer.parseInt(exp[i].split("/")[1]);
                common[1] = common[1] * nums[i][1]; //分母通分
            }
            //给负数赋值
            int index = expression.indexOf('-');
            int index1 = expression.indexOf('/');
            int count = 0;
            while (index != -1) {
                while (index1 < index){
                    count++;
                    index1 = expression.indexOf('/', index1 +1);
                }
                nums[count][0] = -nums[count][0];
                index = expression.indexOf('-', index + 1);
            }
            //分子求和
            for (int i = 0; i < exp.length; i++) {
                temp = common[1] / nums[i][1];
                common[0] = common[0] + temp * nums[i][0];
            }
            //约分
            while (common[0] % 2 == 0 && common[1] % 2 == 0) {
                common[0] = common[0] / 2;
                common[1] = common[1] / 2;
            }
            while (common[0] % 3 == 0 && common[1] % 3 == 0) {
                common[0] = common[0] / 3;
                common[1] = common[1] / 3;
            }
            while (common[0] % 5 == 0 && common[1] % 5 == 0) {
                common[0] = common[0] / 5;
                common[1] = common[1] / 5;
            }
            while (common[0] % 7 == 0 && common[1] % 7 == 0) {
                common[0] = common[0] / 7;
                common[1] = common[1] / 7;
            }
            while (common[0] % 11 == 0 && common[1] % 11 == 0) {
                common[0] = common[0] / 11;
                common[1] = common[1] / 11;
            }

            if (common[0] == 0) {
                common[1] = 1;
            }
            return common[0] + "/" + common[1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}