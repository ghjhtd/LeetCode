package leetcode.editor.cn;

//给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则： 
//
// 
// 给你一个有效的甲板，仅由战舰或者空位组成。 
// 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。 
// 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。 
// 
//
// 示例 : 
//
// 
//X..X
//...X
//...X
// 
//
// 在上面的甲板中有2艘战舰。 
//
// 无效样例 : 
//
// 
//...X
//XXXX
//...X
// 
//
// 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。 
//
// 进阶: 
//
// 你可以用一次扫描算法，只使用O(1)额外空间，并且不修改甲板的值来解决这个问题吗？ 
// Related Topics 深度优先搜索 数组 矩阵 
// 👍 112 👎 0

public class 甲板上的战舰{
	public static void main(String[] args) {
		Solution solution = new 甲板上的战舰().new Solution();
		char[][] test = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
		char[][] test1 = {{'X'},{'X'},{'X'}};
		System.out.println(solution.countBattleships(test1));
	}
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countBattleships(char[][] board) {
    	int sum = 0;
    	if(board == null)
    		return 0;
    	if(board.length == 1 && board[0].length == 1 ){
    		if(board[0][0] == 'X')
    			return 1;
    		else
    			return 0;
		}
		for(int i = 0; i < board.length && board != null; i++){
			for(int j = 0; j < board[i].length; j++){
				if(board[i][j] == 'X'){
					int count = around(i,j,board);
					if(count == 0)
						sum += 2;
					if(count == 1)
						sum += 1;
				}
			}
		}
		return sum/2;
    }

    public int around(int i, int j, char[][] board){
    	int count = 0;
		for(int i1 = i-1; i1 <= i+1;i1 ++){
			if(i1 == i-1){
				int j1 = j;
				if(i1>=0 && i1 < board.length && j1 >= 0 && j1 < board[0].length){
					if(board[i1][j1] == 'X')
						count++;
				}
			}
			if(i1 == i){
				int j1 = j -1;
				if(i1>=0 && i1 < board.length && j1 >= 0 && j1 < board[0].length){
					if(board[i1][j1] == 'X')
						count++;
				}
				j1 = j + 1;
				if(i1>=0 && i1 < board.length && j1 >= 0 && j1 < board[0].length){
					if(board[i1][j1] == 'X')
						count++;
				}
			}
			if(i1 == i+1){
				int j1 = j;
				if(i1>=0 && i1 < board.length && j1 >= 0 && j1 < board[0].length){
					if(board[i1][j1] == 'X')
						count++;
				}
			}
		}
		return count;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}