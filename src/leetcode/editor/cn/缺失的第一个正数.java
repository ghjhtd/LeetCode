package leetcode.editor.cn;

//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 1194 👎 0

import java.util.HashMap;
import java.util.Map;

public class 缺失的第一个正数{
	public static void main(String[] args) {
		Solution solution = new 缺失的第一个正数().new Solution();
		int[] test = new int[]{1};
		System.out.println(solution.firstMissingPositive(test));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i : nums){
			if(i > 0 && i <= nums.length){
				map.put(i,0);
			}
		}
		for(int i = 1; i <= nums.length; i++){
			if(map.get(i) == null){
				return i;
			}
		}
		return nums.length + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}