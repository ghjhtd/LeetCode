package leetcode.editor.cn;

//给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：6
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：24
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,-2,-3]
//输出：-6
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 104 
// -1000 <= nums[i] <= 1000 
// 
// Related Topics 数组 数学 排序 
// 👍 323 👎 0

import java.util.ArrayList;
import java.util.Arrays;

public class 三个数的最大乘积{
	public static void main(String[] args) {
		Solution solution = new 三个数的最大乘积().new Solution();
		int[] ints = new int[]{-1,-2,-3,-4};
		System.out.println(solution.maximumProduct(ints));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumProduct(int[] nums) {
		int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		for(int num: nums){
			if(num < min1){
				min2 = min1;
				min1 = num;
			}
			else if(num < min2){
				min2 = num;
			}

			if(num > max1){
				max3 = max2;
				max2 = max1;
				max1 = num;
			}
			else if(num > max2){
				max3 = max2;
				max2 = num;
			}
			else if(num > max3)
				max3 = num;
		}
		return Math.max(min1*min2*max1, max1*max2*max3);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}