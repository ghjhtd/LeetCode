package leetcode.editor.cn;

//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1138 👎 0

import java.util.Arrays;

public class ThreeSumClosest{
    public static void main(String[] args) {
        Solution solution = new ThreeSumClosest().new Solution();
        solution.threeSumClosest(new int[]{1,1,-1,-1,3}, -1);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int count = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k){
                int temp = nums[i] + nums[j] + nums[k];
                if(temp == target){
                    return temp;
                }
                if(Math.abs(target - temp) < Math.abs(target - count)){
                    count = temp;
                }
                if(temp > target){
                    while (j < k && nums[k] == nums[k - 1]){
                        k--;
                    }
                    k--;
                }
                if(temp < target){
                    while (j < k && nums[j] == nums[j + 1]){
                        j++;
                    }
                    j++;
                }
            }
        }
        return count;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}