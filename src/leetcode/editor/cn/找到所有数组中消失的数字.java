package leetcode.editor.cn;

//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 804 👎 0

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 找到所有数组中消失的数字{
	public static void main(String[] args) {
		Solution solution = new 找到所有数组中消失的数字().new Solution();
		int[] test = new int[]{1,1,2,4,1,5,3,5,4,6,6,3};
		System.out.println(solution.findDisappearedNumbers(test).toArray());
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for(int i: nums){
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		for(int i = 1; i <= nums.length; i++){
			if(map.get(i) == null){
				list.add(i);
			}
		}
		return list;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}