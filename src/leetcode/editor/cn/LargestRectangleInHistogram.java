package leetcode.editor.cn;

//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
// 
//
// 示例 2： 
//
// 
//
// 
//输入： heights = [2,4]
//输出： 4 
//
// 
//
// 提示： 
//
// 
// 1 <= heights.length <=10⁵ 
// 0 <= heights[i] <= 10⁴ 
// 
// Related Topics 栈 数组 单调栈 👍 1908 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new LargestRectangleInHistogram().new Solution();
        System.out.println(solution.largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
       if(n == 0){
           return 0;
       }
       if(n == 1){
           return heights[0];
       }
       int[] newHeight = new int[n + 2];
       for(int i = 0;i < heights.length; i++){
           newHeight[i + 1] = heights[i];
       }
       n += 2;
       heights = newHeight;
       Deque<Integer> stack = new ArrayDeque<>();
       stack.addLast(0);
       int res = 0;
       for(int i = 1; i < n; i++){
            while (heights[i] < heights[stack.peekLast()]){
                int height = heights[stack.removeLast()];
                int width = stack.peekLast();
                width = i - width - 1;
                res = Math.max(res, width * height);
            }
           stack.addLast(i);
       }
       return res;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}