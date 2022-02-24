package leetcode.editor.cn;

//给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。 
//
// 
//
// 示例： 
//
// 
//输入：
//[1,2,3]
//输出：
//3
//解释：
//只需要3次操作（注意每次操作会增加两个元素的值）：
//[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
// 
// Related Topics 数组 数学 
// 👍 248 👎 0

public class 最小操作次数使数组元素相等{
	public static void main(String[] args) {
		Solution solution = new 最小操作次数使数组元素相等().new Solution();
		int[] test = new int[]{1,2,3,1,2,3,2};
		System.out.println(solution.minMoves(test));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMoves(int[] nums) {
		int count = 0;
		int min = Integer.MAX_VALUE;
		for(int i : nums){
			if(i < min)
				min = i;
		}
		for(int i : nums){
			count += (i - min);
		}
		return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}