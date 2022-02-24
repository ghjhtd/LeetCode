package leetcode.editor.cn;

//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。 
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 
// 👍 1002 👎 0

public class 旋转图像{
	public static void main(String[] args) {
		Solution solution = new 旋转图像().new Solution();
		int[][] test = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] test1 = new int[][]{{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
		solution.rotate(test1);
		for(int[] ints:test1){
			for(int i : ints){
				System.out.print(i+"  ");
			}
			System.out.println();
		}
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void rotate(int[][] matrix) {
		for(int i = 0; i < matrix.length/2; i++){
			for(int j = 0; j < matrix[0].length; j++){
				swap(matrix, i, j, matrix.length - i -1,j);
			}
		}
		for(int i = 0; i < matrix.length; i++){
			for(int j = i; j < matrix[0].length; j++){
				swap(matrix, i, j, j,i);
			}
		}
    }
    public int[][] swap(int[][] mat, int y, int x, int y1, int x1){
    	int temp = 0;
    	temp = mat[y][x];
    	mat[y][x] = mat[y1][x1];
    	mat[y1][x1] = temp;
    	return mat;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
	public void rotate(int[][] matrix) {
		int count = 0;
		int m = matrix.length;
		int n = matrix[0].length;
		int x = 0,y = 0;
		int temp = 0, next_temp = 0;
		int x_begin = 0, y_begin = 0;
		while (m > 2 && n > 2){
			temp = matrix[x][x_begin + n - 1];
			matrix[x][x_begin + n - 1] = matrix[y][x];
			next_temp = matrix[y + m - 1][x_begin + n - x - 1];
			matrix[y + m - 1][x_begin + n - x - 1] = temp;
			temp = matrix[y_begin + m - x - 1][x_begin];
			matrix[y_begin + m - x - 1][x_begin] = next_temp;
			matrix[y][x] = temp;

			x++;
			if(x >= matrix[0].length - count - 1){
				count ++;
				y ++;
				x = count;
				m = matrix.length - 2*count;
				n = matrix[0].length - 2*count;
				x_begin = x;
				y_begin = y;
				if(m == 1 || n == 1)
					break;
			}
		}
		if(m == 2 && n == 2){
			temp = matrix[y_begin][x_begin + 1];
			matrix[y_begin][x_begin + 1] = matrix[y_begin][x_begin];
			next_temp = matrix[y_begin + 1][x_begin + 1];
			matrix[y_begin + 1][x_begin + 1] = temp;
			temp = matrix[y_begin + 1][x_begin ];
			matrix[y_begin + 1][x_begin ] = next_temp;
			matrix[y_begin][x_begin] = temp;
		}
	}

}