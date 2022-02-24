package leetcode.editor.cn;

//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。 
//
// 示例: 
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0] 
//
// 说明: 
//
// 
// 必须在原数组上操作，不能拷贝额外的数组。 
// 尽量减少操作次数。 
// 
// Related Topics 数组 双指针 
// 👍 1212 👎 0

public class 移动零{
	public static void main(String[] args) {
		Solution solution = new 移动零().new Solution();
		int[] test = new int[]{0,0,1};
		solution.moveZeroes(test);
		for(int i:test)
			System.out.println(i);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
    	if(nums == null)
    		return;
    	char j = 0;
    	for(short i = 0; i < nums.length; i++){
    		if(nums[i] != 0){
				int temp = nums[i];
    			nums[i] = 0;
    			nums[j++] = temp;
			}
		}
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}