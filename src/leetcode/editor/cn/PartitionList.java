package leetcode.editor.cn;

//给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。 
//
// 你应当 保留 两个分区中每个节点的初始相对位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,4,3,2,5,2], x = 3
//输出：[1,2,2,4,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [2,1], x = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 200] 内 
// -100 <= Node.val <= 100 
// -200 <= x <= 200 
// 
// Related Topics 链表 双指针 👍 558 👎 0

public class PartitionList{
    public static void main(String[] args) {
        Solution solution = new PartitionList().new Solution();
        ListNode listNode = new ListNode(1);
        int[] ints = new int[]{1,4,3,0,2,5,2};
        for(int i : ints){
            listNode.add(i);
        }
        System.out.println(solution.partition(listNode.next, 3));
    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode list = new ListNode();
        list.next = head;
        ListNode tempList = new ListNode();
        ListNode temp = list;
        ListNode newTemp = tempList;
        while (temp.next != null){
            ListNode pre = temp;
            temp = temp.next;
            if(temp.val < x){
                pre.next = temp.next;
                newTemp.next = temp;
                newTemp = newTemp.next;
                temp = pre;
            }
        }
        newTemp.next = list.next;
        return tempList.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    public void add(int val) {
        ListNode list = this;
        while (list.next != null) {
            list = list.next;
        }
        ListNode temp = new ListNode(val);
        list.next = temp;
    }
}

}