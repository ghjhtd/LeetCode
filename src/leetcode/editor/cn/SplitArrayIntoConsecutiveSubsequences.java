package leetcode.editor.cn;

//给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。 
//
// 如果可以完成上述分割，则返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: [1,2,3,3,4,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3
//3, 4, 5
// 
//
// 示例 2： 
//
// 
//输入: [1,2,3,3,4,4,5,5]
//输出: True
//解释:
//你可以分割出这样两个连续子序列 : 
//1, 2, 3, 4, 5
//3, 4, 5
// 
//
// 示例 3： 
//
// 
//输入: [1,2,3,4,4,5]
//输出: False
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10000 
// 
// Related Topics 贪心 数组 哈希表 堆（优先队列） 👍 368 👎 0

import java.util.HashMap;
import java.util.Map;

public class SplitArrayIntoConsecutiveSubsequences{
    public static void main(String[] args) {
        Solution solution = new SplitArrayIntoConsecutiveSubsequences().new Solution();
        System.out.println(solution.isPossible(new int[]{1,2,3,4,4,5}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> end = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for(int i : nums){
            int num = map.get(i);
            if(num > 0){
                int pre_end = end.getOrDefault(i - 1, 0);
                if(pre_end > 0){
                    map.put(i, num - 1);
                    end.put(i - 1, pre_end - 1);
                    end.put(i, end.getOrDefault(i, 0) + 1);
                }else{
                    int num1 = map.getOrDefault(i + 1, 0);
                    int num2 = map.getOrDefault(i + 2, 0);
                    if(num1 > 0 && num2 > 0){
                        map.put(i, num - 1);
                        map.put(i + 1, num1 - 1);
                        map.put(i + 2, num2 - 1);
                        end.put(i + 2, end.getOrDefault(i + 2, 0) + 1);
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}