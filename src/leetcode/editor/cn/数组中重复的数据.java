package leetcode.editor.cn;

//给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。 
//
// 找到所有出现两次的元素。 
//
// 你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？ 
//
// 示例： 
//
// 
//输入:
//[4,3,2,7,8,2,3,1]
//
//输出:
//[2,3]
// 
// Related Topics 数组 哈希表 
// 👍 426 👎 0

import java.util.ArrayList;
import java.util.List;

public class 数组中重复的数据{
	public static void main(String[] args) {
		Solution solution = new 数组中重复的数据().new Solution();
		int[] test = new int[]{4,3,2,7,8,2,3,1};
		List list;
		list = solution.findDuplicates(test);
		for(Object i: list){
			System.out.println(i);
		}
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
    	List<Integer> list = new ArrayList<Integer>();
		for(int i : nums){
			nums[(i % (nums.length + 1))-1] += (nums.length+1);
		}
		for(int i = 0; i < nums.length; i++){
			if(nums[i] / (nums.length+1) == 2)
				list.add(i + 1);
		}
		return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}