package leetcode.editor.cn;

//给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。 
//
// 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: root = [5,2,-3]
//输出: [2,-3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入: root = [5,2,-5]
//输出: [2]
// 
//
// 
//
// 提示: 
//
// 
// 节点数在 [1, 10⁴] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 哈希表 二叉树 👍 145 👎 0

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostFrequentSubtreeSum{
    public static void main(String[] args) {
        Solution solution = new MostFrequentSubtreeSum().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        sum(root, map);
        int max = 0;
        for(int i : map.values()){
            max = Math.max(max, i);
        }
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i : map.keySet()){
            if(map.get(i) == max){
                list.add(i);
            }
        }
       int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }
        return ints;
    }

    public int sum(TreeNode node, Map<Integer, Integer> map){
        if(node == null){
            return 0;
        }
        int sum = node.val;
        sum += sum(node.left, map);
        sum += sum(node.right, map);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
}