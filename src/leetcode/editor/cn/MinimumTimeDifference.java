package leetcode.editor.cn;

//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 189 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {
    public static void main(String[] args) {
        Solution solution = new MinimumTimeDifference().new Solution();
        String[] timePoints = {"23:59", "00:00"};
        System.out.println(solution.findMinDifference(Arrays.asList(timePoints)));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {
            if (timePoints == null) {
                return 0;
            }
            int n = timePoints.size();
            int[][] times = new int[timePoints.size()][3];
            int index = 0;
            int[] minutes = new int[timePoints.size()];
            int min = Integer.MAX_VALUE;
            for (String s : timePoints) {
                times[index][0] = Integer.parseInt(s.split(":")[0]);
                times[index][1] = Integer.parseInt(s.split(":")[1]);
                times[index][2] = times[index][0] * 60 + times[index][1];
                index++;
            }
            Arrays.sort(times, (a, b) -> a[2] - b[2]);
            for (int i = 0; i < timePoints.size() - 1; i++) {
                if ((times[(i + 1) % timePoints.size()][2] - times[i][2]) < min) {
                    min = times[(i + 1) % timePoints.size()][2] - times[i][2];
                }
            }
            if ((times[0][2] - times[n - 1][2]) < 0) {
                if ((24 * 60 - times[n - 1][2] + times[0][2]) < min) {
                    min = 24 * 60 - times[n - 1][2] + times[0][2];
                }
            }
            return min;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)
}
