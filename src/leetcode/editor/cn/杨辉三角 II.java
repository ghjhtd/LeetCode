package leetcode.editor.cn;

//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
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
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1

//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？
// Related Topics 数组 动态规划 
// 👍 318 👎 0

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

class 杨辉三角II{
	public static void main(String[] args) {
		Solution solution = new 杨辉三角II().new Solution();
        List list = solution.getRow(5);
        for(Object i: list){
            System.out.println(i);
        }
	}
//lfetcode submit region begin(Prohibit modification and deletion)
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        List<Integer> pre = new ArrayList<>();
        rowIndex += 1;
        if(rowIndex == 0){
            return null;
        }
        pre.add(1);
        if(rowIndex == 1){
            return pre;
        }
        pre.add(1);
        if(rowIndex == 2){
            return pre;
        }
        for(int i = 3; i <= rowIndex; i ++){
            result = nextLine(pre);
            pre = result;
        }
        return result;
    }

    List<Integer> nextLine(List<Integer> pre){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i = 0; i < pre.size() - 1; i ++){
            list.add(pre.get(i) + pre.get(i + 1));
        }
        list.add(1);
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}