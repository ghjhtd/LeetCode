package leetcode.editor.cn;

//给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。 
//
// 请你找出符合题意的 最短 子数组，并输出它的长度。 
//
// 
//
// 
// 
// 示例 1： 
//
// 
//输入：nums = [2,6,4,8,10,9,15]
//输出：5
//解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？ 
// 
// 
// Related Topics 栈 贪心 数组 双指针 排序 单调栈 👍 834 👎 0

public class ShortestUnsortedContinuousSubarray{
    public static void main(String[] args) {
        Solution solution = new ShortestUnsortedContinuousSubarray().new Solution();
        System.out.println(solution.findUnsortedSubarray(new int[]{1,2,3,4}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        if(nums.length == 1){
            return 0;
        }
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i + 1] < nums[i]){
                max = Math.max(max, nums[i]);
                min = Math.min(min, nums[i + 1]);
            }
        }
        if(min == Integer.MAX_VALUE){
            return 0;
        }
        int l_index = 0, r_index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > min){
                l_index = i;
                break;
            }
        }
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] < max){
                r_index = i;
                break;
            }
        }
        return r_index - l_index + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}