package leetcode.editor.cn;

//给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果 NestedInteger 。 
//
// 列表中的每个元素只可能是整数或整数嵌套列表 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "324",
//输出：324
//解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
// 
//
// 示例 2： 
//
// 
//输入：s = "[123,[456,[789]]]",
//输出：[123,[456,[789]]]
//解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
//1. 一个 integer 包含值 123
//2. 一个包含两个元素的嵌套列表：
//    i.  一个 integer 包含值 456
//    ii. 一个包含一个元素的嵌套列表
//         a. 一个 integer 包含值 789
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// s 由数字、方括号 "[]"、负号 '-' 、逗号 ','组成 
// 用例保证 s 是可解析的 NestedInteger 
// 输入中的所有值的范围是 [-10⁶, 10⁶] 
// 
// Related Topics 栈 深度优先搜索 字符串 👍 84 👎 0

public class MiniParser{
    public static void main(String[] args) {
        Solution solution = new MiniParser().new Solution();
        
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    char[] chars = null;
    int index = 0;
    public NestedInteger deserialize(String s) {
        chars = s.toCharArray();
        if(chars[0] != '['){return new NestedInteger(Integer.parseInt(s));}
        return re();
    }

    public NestedInteger re(){
        NestedInteger nest = new NestedInteger();
        int num = 0;
        int signed = 1;
        while (index != chars.length - 1){
            index++;
            if(chars[index] == ','){continue;}
            if(chars[index] == '['){nest.add(re());}
            else if(chars[index] == '-'){signed = -1;}
            else if(chars[index] == ']'){return nest;}
            else {
                num = num*10 + signed * (chars[index] - '0');
                if(chars[index+1] == ']' || chars[index + 1] == ','){
                    nest.add(new NestedInteger(num));
                    signed = 1;
                    num = 0;
                }
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class NestedInteger{

    public NestedInteger(int parseInt) {
    }

    public NestedInteger() {

    }

    public void add(NestedInteger num) {
    }
}
}