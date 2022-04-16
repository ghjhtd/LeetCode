package leetcode.editor.cn;

//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 10⁴ 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 10⁴ 
// 
// Related Topics 数组 排序 👍 1429 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
        for(int[] ints : solution.merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}})){
            System.out.println(Arrays.toString(ints));
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> list = new ArrayList<>();
        int[] pre = intervals[0];
        for(int[] ints : intervals){
            if(pre[1] >= ints[0]){
                if(ints[1] > pre[1]){
                    pre[1] = ints[1];
                }else {
                    continue;
                }
            }else {
                list.add(pre);
                pre = ints;
            }
        }
        list.add(pre);
        return (int[][]) list.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}