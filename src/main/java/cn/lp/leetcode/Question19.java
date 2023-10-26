package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-29  15:43
 * @Description: TODO
 * @Version: 1.0
 */
public class Question19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(-1, head);
        ListNode slow = listNode;
        ListNode fast = listNode;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return listNode.next;
    }
}
