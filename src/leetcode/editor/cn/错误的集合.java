package leetcode.editor.cn;

//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。 
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 位运算 数组 哈希表 排序 
// 👍 226 👎 0

import java.util.Arrays;

public class 错误的集合{
	public static void main(String[] args) {
		Solution solution = new 错误的集合().new Solution();
		int[] test = new int[]{1,5,3,2,2,7,6,4,8,9};
		int[] out = new int[]{0,0};
		out = solution.findErrorNums(test);
		System.out.println(out[0] + "  " + out[1]);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findErrorNums(int[] nums) {
    	int[] resoults = new int[2];
		Arrays.sort(nums);
		for(int i = 0; i < nums.length - 1; i++){
			if(i == 0 && nums[i] == 2)
				resoults[1] = 1;
			if(nums[i] == nums[i + 1]){
				resoults[0] = nums[i];
			}
			if(nums[i + 1] - nums[i] > 1){
				resoults[1] = nums[i] + 1;
			}
		}
		if(nums[nums.length - 1] != nums.length)
			resoults[1] = nums[nums.length - 1] + 1;
		return resoults;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}