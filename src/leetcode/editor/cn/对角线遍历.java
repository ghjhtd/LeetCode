package leetcode.editor.cn;

//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 230 👎 0

public class 对角线遍历{
	public static void main(String[] args) {
		Solution solution = new 对角线遍历().new Solution();
		int[][] test = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[] result = solution.findDiagonalOrder(test);
		for(int i : result)
			System.out.println(i);
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
		int[][] inc = new int[][]{{1,-1},{-1,1}};
		int m = mat.length;
		int n = mat[0].length;
		int incIndex = 0;
		int[] result = new int[m * n];
		int y = 0, next_y = 0;
		int x = 0, next_x = 0;
		if(mat.length == 0 || mat[0].length == 0)
			return new int[0];
		if(mat.length == 1){
			int i = 0;
			for(int k : mat[0])
				result[i++] = k;
			return result;
		}
		if(mat[0].length == 1){
			int i = 0;
			for(int[] k : mat)
				result[i++] = k[0];
			return result;
		}
		result[0] = mat[y][x++];
		for(int i =1; i < m*n; i++){
			result[i] = mat[y][x];
			next_x = x + inc[incIndex][1];
			next_y = y + inc[incIndex][0];
			if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= m){
				incIndex ++;
				incIndex %= 2;
				if(next_x < 0 && next_y < m){
					x = x;
					y = next_y;
					continue;
				}
				if(next_x < 0 && next_y >= m){
					x = x + 1;
					y = y;
					continue;
				}
				if(next_x < n && next_y < 0){
					x = x + 1;
					y = y;
					continue;
				}
				if(next_x >= n && next_y < 0){
					x = x;
					y = y + 1;
					continue;
				}
				if(next_x < n && next_y >= m){
					x = x + 1;
					y = y;
					continue;
				}
				if(next_x >= n && next_y < m){
					x = x;
					y = y + 1;
					continue;
				}
			}
			x = next_x;
			y = next_y;
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}