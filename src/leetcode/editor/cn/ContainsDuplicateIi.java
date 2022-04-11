package leetcode.editor.cn;

//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i 
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3,1], k = 3
//输出：true 
//
// 示例 2： 
//
// 
//输入：nums = [1,0,1,1], k = 1
//输出：true 
//
// 示例 3： 
//
// 
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false 
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// 0 <= k <= 10⁵ 
// 
// Related Topics 数组 哈希表 滑动窗口 👍 463 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContainsDuplicateIi{
    public static void main(String[] args) {
        Solution solution = new ContainsDuplicateIi().new Solution();
        System.out.println(solution.containsNearbyDuplicate(new int[]{1,2,3,1}, 3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List list;
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                list = map.get(nums[i]);
            }else{
                list = new ArrayList<Integer>();
            }
            list.add(i);
            map.put(nums[i], list);
        }
        for(int i : map.keySet()){
            if(map.get(i).size() >= 2){
                list = map.get(i);
                Object[] ints = list.toArray();
                for(int j = 0; j < ints.length - 1; j++){
                    if(Math.abs((int)ints[j + 1] - (int)ints[j]) <= k){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}