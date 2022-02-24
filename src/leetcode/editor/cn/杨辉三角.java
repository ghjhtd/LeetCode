package leetcode.editor.cn;

//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 567 👎 0

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角{
	public static void main(String[] args) {
		Solution solution = new 杨辉三角().new Solution();
		solution.generate(1000);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		if(numRows == 0)
			return result;
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		list1.add(1);
		list2.add(1);
		list2.add(1);
		result.add(list1);
		if(numRows == 1)
			return result;
		result.add(list2);
		if(numRows == 2)
			return result;
		for(int i = 2; i < numRows; i++){
			List<Integer> list3 = new ArrayList<>();
			list3 = create(result.get(i-1));
			result.add(list3);
		}
		return result;
    }
    public List<Integer> create(List<Integer> pre){
    	List<Integer> list = new ArrayList<>();
    	list.add(1);
    	for(int i = 0; i < pre.size() - 1; i++){
    		list.add(pre.get(i) + pre.get(i + 1));
		}
		list.add(1);
    	return list;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}