package leetcode.editor.cn;

//给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"]
//,["1","0","0","1","0"]]
//输出：6
//解释：最大矩形如上图所示。
// 
//
// 示例 2： 
//
// 
//输入：matrix = []
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：matrix = [["0"]]
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：matrix = [["1"]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：matrix = [["0","0"]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// rows == matrix.length 
// cols == matrix[0].length 
// 1 <= row, cols <= 200 
// matrix[i][j] 为 '0' 或 '1' 
// 
// Related Topics 栈 数组 动态规划 矩阵 单调栈 👍 1259 👎 0

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class MaximalRectangle{
    public static void main(String[] args) {
        Solution solution = new MaximalRectangle().new Solution();
        //System.out.println(solution.maximalRectangle(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
        System.out.println(solution.maximalRectangle(new char[][]{{'0','1'},{'1', '0'}}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] ints = new int[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '1'){
                    ints[i][j] = 1;
                }
            }
        }
        int res = 0;
        int[] temp = new int[m];
        for(int i = 0; i < n; i++){
            if(i != 0){
                for(int j = 0; j < m; j++){
                    if(ints[i][j] == 1){
                        ints[i][j] = ints[i][j] + ints[i - 1][j];
                    }
                }
            }
            res = Math.max(res, max_rec(ints[i]));
        }
        return res;
    }

    public int max_rec(int[] ints){
        if(ints.length == 1){
            return ints[0];
        }
        int[] newInts = new int[ints.length + 2];
        int n = newInts.length;
        for(int i = 0;i < ints.length; i++){
            newInts[i + 1] = ints[i];
        }
        ints = newInts;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        int res = 0;
        for(int i = 1; i < ints.length; i++){
            while (ints[i] < ints[stack.peekLast()]){
                int height = ints[stack.removeLast()];
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