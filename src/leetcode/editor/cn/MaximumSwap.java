package leetcode.editor.cn;

//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
// Related Topics 贪心 数学 👍 228 👎 0

public class MaximumSwap{
    public static void main(String[] args) {
        Solution solution = new MaximumSwap().new Solution();
        System.out.println(solution.maximumSwap(1993));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        int length = (num + "").length();
        char[] nums = (num + "").toCharArray();
        char max ;
        int index = 0;
        for(int i = 0; i < length - 1; i++){
            max = nums[i];
            for (int j = i +1; j < length; j++){
                if(nums[j] >= max){
                    max = nums[j];
                    index = j;
                }
            }
            if(nums[i] < max){
                char temp = nums[index];
                nums[index] = nums[i];
                nums[i] = temp;
                return Integer.parseInt(String.valueOf(nums));
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}