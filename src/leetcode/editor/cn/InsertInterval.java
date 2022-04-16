package leetcode.editor.cn;

//给你一个 无重叠的 ，按照区间起始端点排序的区间列表。 
//
// 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
//输出：[[1,5],[6,9]]
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//输出：[[1,2],[3,10],[12,16]]
//解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。 
//
// 示例 3： 
//
// 
//输入：intervals = [], newInterval = [5,7]
//输出：[[5,7]]
// 
//
// 示例 4： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,3]
//输出：[[1,5]]
// 
//
// 示例 5： 
//
// 
//输入：intervals = [[1,5]], newInterval = [2,7]
//输出：[[1,7]]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 10⁵ 
// intervals 根据 intervals[i][0] 按 升序 排列 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 10⁵ 
// 
// Related Topics 数组 👍 570 👎 0

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval{
    public static void main(String[] args) {
        Solution solution = new InsertInterval().new Solution();
        for(int[] ints : solution.insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8})){
            System.out.println(Arrays.toString(ints));
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length == 0){
            return new int[][]{newInterval};
        }
        int[][] ints = new int[intervals.length + 1][2];
        for(int i = 0; i < intervals.length; i++){
            ints[i] = intervals[i];
        }
        ints[intervals.length] = newInterval;
        Arrays.sort(ints, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int[] pre = ints[0];
        for(int[] ii : ints){
            if(pre[1] >= ii[0]){
                if(ii[1] > pre[1]){
                    pre[1] = ii[1];
                }else {
                    continue;
                }
            }else {
                list.add(pre);
                pre = ii;
            }
        }
        list.add(pre);
        return (int[][]) list.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}