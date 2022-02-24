package leetcode.editor.cn;

//给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 477 👎 0

class 螺旋矩阵II{
	public static void main(String[] args) {
		Solution solution = new 螺旋矩阵II().new Solution();
		
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		boolean[][] booleans = new boolean[n][n];
		int[][] inc = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		int incIndex = 0;
		int x = 0, next_x = 0;
		int y = 0, next_y = 0;
		for(int i = 1; i <= n*n; i++){
			result[y][x] = i;
			booleans[y][x] = true;
			next_x = x + inc[incIndex][1];
			next_y = y + inc[incIndex][0];
			if(next_x < 0 || next_x >= n || next_y < 0 || next_y >= n || booleans[next_y][next_x] == true){
				incIndex ++;
				incIndex %= 4;
			}
			x += inc[incIndex][1];
			y += inc[incIndex][0];
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}