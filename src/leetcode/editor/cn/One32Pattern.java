package leetcode.editor.cn;

//给你一个整数数组 nums ，数组中共有 n 个整数。132 模式的子序列 由三个整数 nums[i]、nums[j] 和 nums[k] 组成，并同时满足
//：i < j < k 和 nums[i] < nums[k] < nums[j] 。 
//
// 如果 nums 中存在 132 模式的子序列 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,4]
//输出：false
//解释：序列中不存在 132 模式的子序列。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,1,4,2]
//输出：true
//解释：序列中有 1 个 132 模式的子序列： [1, 4, 2] 。
// 
//
// 示例 3： 
//
// 
//输入：nums = [-1,3,2,0]
//输出：true
//解释：序列中有 3 个 132 模式的的子序列：[-1, 3, 2]、[-1, 3, 0] 和 [-1, 2, 0] 。
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 2 * 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 栈 数组 二分查找 有序集合 单调栈 👍 644 👎 0

import java.util.Map;
import java.util.TreeMap;

public class One32Pattern{
    public static void main(String[] args) {
        Solution solution = new One32Pattern().new Solution();
        System.out.println(solution.find132pattern(new int[]{-1,3,2,0}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if(n < 3){
            return false;
        }
        int left_Min = nums[0];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 2; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for(int i = 1; i < nums.length - 1; i++){
            if(nums[i] > left_Min){
                Integer temp = map.ceilingKey(left_Min + 1);
                if(temp != null && temp < nums[i]){
                    return true;
                }
            }
            left_Min = Math.min(left_Min, nums[i]);
            map.put(nums[i + 1], map.get(nums[i + 1]) - 1);
            if(map.get(nums[i + 1]) == 0){
                map.remove(nums[i + 1]);
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}