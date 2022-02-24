package leetcode.editor.cn;

//给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值。 
//
// 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。 
//
// 
//
// 示例 1： 
//
// 
//输入：[1, 2, 2, 3, 1]
//输出：2
//解释：
//输入数组的度是2，因为元素1和2的出现频数最大，均为2.
//连续子数组里面拥有相同度的有如下所示:
//[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
//最短连续子数组[2, 2]的长度为2，所以返回2.
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2,3,1,4,2]
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// nums.length 在1到 50,000 区间范围内。 
// nums[i] 是一个在 0 到 49,999 范围内的整数。 
// 
// Related Topics 数组 哈希表 
// 👍 364 👎 0

import java.util.HashMap;
import java.util.Map;

public class 数组的度{
	public static void main(String[] args) {
		Solution solution = new 数组的度().new Solution();
		int[] test = new int[]{1,3,2,2,3,1};
		System.out.println(solution.findShortestSubArray(test));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max_count = Integer.MIN_VALUE, min_key = 0;
		int size = 0;
		int count = 0, final_size = Integer.MAX_VALUE;
		for(int i: nums){
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for(Map.Entry<Integer,Integer> entry: map.entrySet()){
			if(entry.getValue() > max_count){
				max_count = entry.getValue();
			}
		}
		for(Map.Entry<Integer,Integer> entry: map.entrySet()){
			if(entry.getValue() == max_count){
				max_count = entry.getValue();
				min_key = entry.getKey();
				count = 0;
				size = 0;
				for(int i: nums){
					if(i == min_key)
						count++;
					if(count < map.get(min_key) && count > 0)
						size++;
				}
				if(size < final_size)
					final_size = size;
			}
		}
		return final_size + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}