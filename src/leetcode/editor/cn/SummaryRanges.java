package leetcode.editor.cn;

//给定一个 无重复元素 的 有序 整数数组 nums 。 
//
// 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 
//nums 的数字 x 。 
//
// 列表中的每个区间范围 [a,b] 应该按如下格式输出： 
//
// 
// "a->b" ，如果 a != b 
// "a" ，如果 a == b 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [0,1,2,4,5,7]
//输出：["0->2","4->5","7"]
//解释：区间范围是：
//[0,2] --> "0->2"
//[4,5] --> "4->5"
//[7,7] --> "7"
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,2,3,4,6,8,9]
//输出：["0","2->4","6","8->9"]
//解释：区间范围是：
//[0,0] --> "0"
//[2,4] --> "2->4"
//[6,6] --> "6"
//[8,9] --> "8->9"
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 20 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// nums 中的所有值都 互不相同 
// nums 按升序排列 
// 
// Related Topics 数组 👍 210 👎 0

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges{
    public static void main(String[] args) {
        Solution solution = new SummaryRanges().new Solution();
        for(String s : solution.summaryRanges(new int[]{0,2,3,4,6,8,9})){
            System.out.println(s);
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> summaryRanges(int[] nums) {
        if(nums.length == 0){
            return new ArrayList<>();
        }
        List<String> list = new ArrayList<>();
        int first = nums[0], last = first;
        for(int i : nums){
            if(last != i){
                if(last - 1 != first){
                    list.add(first + "->" + (last - 1));
                }else {
                    list.add(first + "");
                }
                first = i;
                last = first + 1;
            }else {
                last++;
            }
        }
        if(nums[nums.length - 1] == first){
            list.add(first + "");
        }else{
            list.add(first + "->" + (last - 1));
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}