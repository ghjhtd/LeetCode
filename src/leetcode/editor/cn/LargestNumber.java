package leetcode.editor.cn;

//给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。 
//
// 注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [10,2]
//输出："210" 
//
// 示例 2： 
//
// 
//输入：nums = [3,30,34,5,9]
//输出："9534330"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 10⁹ 
// 
// Related Topics 贪心 字符串 排序 👍 918 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber{
    public static void main(String[] args) {
        Solution solution = new LargestNumber().new Solution();
        System.out.println(solution.largestNumber(new int[]{0,0}));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s[i] = nums[i] + "";
        }
        Arrays.sort(s, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        StringBuilder builder = new StringBuilder();
        for(String s1 : s){
            builder.append(s1);
        }
        String ss = builder.toString();
        for(int i = 0; i < ss.length(); i++){
            if(ss.charAt(i) != '0'){
                if(i == ss.length() - 1){
                    return ss.charAt(i) + "";
                }
                return ss.substring(i, ss.length());
            }
        }
        return "0";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}