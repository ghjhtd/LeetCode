package leetcode.editor.cn;

//包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值
//求平均，如果周围的单元格不足八个，则尽可能多的利用它们。 
//
// 示例 1: 
//
// 
//输入:
//[[1,1,1],
// [1,0,1],
// [1,1,1]]
//输出:
//[[0, 0, 0],
// [0, 0, 0],
// [0, 0, 0]]
//解释:
//对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
//对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
//对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
// 
//
// 注意: 
//
// 
// 给定矩阵中的整数范围为 [0, 255]。 
// 矩阵的长和宽的范围均为 [1, 150]。 
// 
// Related Topics 数组 矩阵 
// 👍 84 👎 0

public class 图片平滑器{
	public static void main(String[] args) {
		Solution solution = new 图片平滑器().new Solution();
		int[][] test = {{1,1,1},{1,0,1},{1,1,1}};
		test = solution.imageSmoother(test);
		for(int[] ints: test){
			for(int i :ints)
				System.out.print(i + " ");
			System.out.println();
		}
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] imageSmoother(int[][] img) {
		int m = img.length, n = img[0].length;
		int[][] result = new int[img.length][img[0].length];
		int sum = 0,count = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				result[i][j] = returnSum(img, i ,j);
			}
		}
		return result;
    }

    public int returnSum(int[][] img,int x, int y){
    	int sum = 0, count = 0;
    	int m = img.length, n = img[0].length;
		for(int i = x - 1; i <= x + 1; i++){
			for(int j = y - 1; j <= y + 1; j++){
				if (i >= 0 && i < img.length && j >= 0 && j < img[0].length){
					sum += img[i][j];
					count ++;
				}
			}
		}
		return sum/count;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}