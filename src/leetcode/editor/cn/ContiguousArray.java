package leetcode.editor.cn;

//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
// Related Topics 数组 哈希表 前缀和 👍 543 👎 0

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray{
    public static void main(String[] args) {
        Solution solution = new ContiguousArray().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int maxLength = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
            }else{
                count--;
            }
            if(map.containsKey(count)){
                int index = map.get(count);
                maxLength = Math.max(maxLength, i - index);
            }else {
                map.put(count, i);
            }
        }
        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}