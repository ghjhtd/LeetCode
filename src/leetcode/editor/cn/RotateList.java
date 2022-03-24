package leetcode.editor.cn;

//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
// 
//
// 示例 2： 
//
// 
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 500] 内 
// -100 <= Node.val <= 100 
// 0 <= k <= 2 * 10⁹ 
// 
// Related Topics 链表 双指针 👍 743 👎 0

public class RotateList{
    public static void main(String[] args) {
        Solution solution = new RotateList().new Solution();
        
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        ListNode list = new ListNode();
        ListNode temp = list;
        ListNode tail = null;
        list.next = head;
        int length = 0;
        while(temp.next != null){
            length++;
            temp = temp.next;
        }
        k = k % length;
        if(k == 0){
            return list.next;
        }
        temp = list;
        for(int i = 0; i < length - k; i++){
            temp = temp.next;
        }
        tail = temp.next;
        while (tail.next != null){
            tail = tail.next;
        }
        tail.next = list.next;
        list.next = temp.next;
        temp.next = null;
        return list.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
}