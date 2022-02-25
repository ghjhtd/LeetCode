package leetcode.editor.cn;

//求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。 
//
// 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。 
//
// 如果方程中只有一个解，要保证返回值 'x' 是一个整数。 
//
// 
//
// 示例 1： 
//
// 
//输入: equation = "x+5-3+x=6+x-2"
//输出: "x=2"
// 
//
// 示例 2: 
//
// 
//输入: equation = "x=x"
//输出: "Infinite solutions"
// 
//
// 示例 3: 
//
// 
//输入: equation = "2x=x"
//输出: "x=0"
// 
//
// 
//
// 
//
// 提示: 
//
// 
// 3 <= equation.length <= 1000 
// equation 只有一个 '='. 
// equation 方程由整数组成，其绝对值在 [0, 100] 范围内，不含前导零和变量 'x' 。 
// 
// Related Topics 数学 字符串 模拟 👍 81 👎 0

public class SolveTheEquation{
    public static void main(String[] args) {
        Solution solution = new SolveTheEquation().new Solution();
        System.out.println(solution.solveEquation("x+5-3+x=6+x-2"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String solveEquation(String equation) {
        if(equation == null){
            return null;
        }
        equation = equation.replace("-", "+-");
        String[] L_string = equation.split("=")[0].split("\\+");
        String[] R_string = equation.split("=")[1].split("\\+");

        int[] resoult = {0, 0};
        resoult[0] = get_x(L_string) - get_x(R_string);
        resoult[1] = get_num(R_string) - get_num(L_string);
        if(resoult[0] == 0){
            if(resoult[1] == 0){
                return "Infinite solutions";
            }
            return "No solution";
        }
        return "x=" + resoult[1]/resoult[0];
    }

    public int get_x(String[] s){
        int num = 0;
        for(String str : s){
            if(str.contains("x") && !str.equals("")){
                if(str.length() == 1 || str.equals("-x")){
                    if(str.length() == 1){
                        num += 1;
                    }else{
                        num -= 1;
                    }

                }else{
                    str = str.replace("x", "");
                    num += Integer.parseInt(str);
                }
            }
        }
        return num;
    }
    public int get_num(String[] s){
        int num = 0;
        for(String str : s){
            if(str.contains("x") == false && !str.equals("")){
                num += Integer.parseInt(str);
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}