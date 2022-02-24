package leetcode.editor.cn;

//给定一个二进制数组， 计算其中最大连续 1 的个数。 
//
// 
//
// 示例： 
//
// 
//输入：[1,1,0,1,1,1]
//输出：3
//解释：开头的两位和最后的三位都是连续 1 ，所以最大连续 1 的个数是 3.
// 
//
// 
//
// 提示： 
//
// 
// 输入的数组只包含 0 和 1 。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组 
// 👍 261 👎 0

class 最大连续_1_的个数{
	public static void main(String[] args) {
	    int[] test = new int[]{1,1,0,0,1,1,1,1,1,0,0,1};
		Solution solution = new 最大连续_1_的个数().new Solution();
        System.out.println(solution.findMaxConsecutiveOnes(test));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max_Count = 0;
        int count = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] == 1){
			    count++;
			    if(count > max_Count)
			        max_Count = count;
            }
            else{
                count = 0;
            }
		}
		return max_Count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}