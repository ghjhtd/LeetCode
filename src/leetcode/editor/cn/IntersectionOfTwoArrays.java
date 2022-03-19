package leetcode.editor.cn;

//给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[9,4]
//解释：[4,9] 也是可通过的
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length, nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 1000 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 505 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays{
    public static void main(String[] args) {
        Solution solution = new IntersectionOfTwoArrays().new Solution();
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        for(Object i : solution.intersection(nums1, nums2)){
            System.out.println(i);
        }
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map map1 = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: nums1){
            map1.put(i, map1.containsKey(i) ? (int)map1.get(i) + 1 : 1);
        }
        for(int j : nums2){
            if(map1.containsKey(j) && !list.contains(j)){
                list.add(j);
            }
        }
        int[] ints = new int[list.size()];
        int index = 0;
        for(int i : list){
            ints[index++] = i;
        }
        return  ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}