package leetcode.editor.cn;

//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 前缀和 
// 👍 909 👎 0

public class 除自身以外数组的乘积{
	public static void main(String[] args) {
		Solution solution = new 除自身以外数组的乘积().new Solution();
		int[] test = {-1,1,0,-3,3};
		test = solution.productExceptSelf(test);
		for(int i : test)
			System.out.print(i);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
		int count = 1, count_zero = 0, zero_index = 0, zero_count = 0;
		int[] result = new int[nums.length];
		for(int i :nums){
			count *=  i;
			if(i == 0){
				count_zero++;
				zero_index = zero_count;
			}
			zero_count++;
		}
		if(count_zero > 1)
			return result;
		if(count_zero == 1){
			int sum = 1;
			for(int i : nums){
				if(i != 0)
					sum *= i;
			}
			result[zero_index] = sum;
			return result;
		}
		for(int i = 0; i < nums.length; i++){
			result[i] = count / nums[i];
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}