package leetcode.editor.cn;

//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 864 👎 0

import java.util.ArrayList;
import java.util.List;

public class 螺旋矩阵{
	public static void main(String[] args) {
		Solution solution = new 螺旋矩阵().new Solution();
		int[][] test = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> list = solution.spiralOrder(test);
		for(int i : list)
			System.out.println(i);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length, x = 0, next_x = 0;
		int n = matrix[0].length, y = 0, next_y = 0;
		List<Integer> list = new ArrayList<>();
		boolean[][] booleans = new boolean[matrix.length][matrix[0].length];
		int[][] inc = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		int incIndex = 0;
		for(int i = 0; i < m * n; i ++){
			list.add(matrix[y][x]);
			booleans[y][x] = true;
			next_y = y + inc[incIndex][0];
			next_x = x + inc[incIndex][1];
			if(next_y < 0 || next_y >= matrix.length || next_x < 0 || next_x >= matrix[0].length || booleans[next_y][next_x] == true){
				incIndex ++;
				incIndex = incIndex % 4;
			}
			x += inc[incIndex][1];
			y += inc[incIndex][0];
		}
		return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}