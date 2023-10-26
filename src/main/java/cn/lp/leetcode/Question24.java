package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-29  17:34
 * @Description: TODO
 * @Version: 1.0
 */
public class Question24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
//        1->2->3->4
//        2->1->4->3
        ListNode newHead = head.next;
        head.next = swapPairs(newHead.next);
        newHead.next = head;
        return newHead;
    }
}
