package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-01-25  10:54
 * @Description: TODO
 * @Version: 1.0
 */
class Qusetion25 {
    public static ListNode reverseKGroup(ListNode head, int k) {
            ListNode hair = new ListNode(-1, head), prev = hair;
            while (true) {
                // 检查剩余节点是否有k个，不足则返回
                ListNode last = prev;
                for (int i = 0; i < k; i++) {
                    last = last.next;
                    if (last == null) {
                        return hair.next;
                    }
                }
                ListNode curr = prev.next, next;
                for (int i = 0; i < k - 1; i++) {
                    next = curr.next;        //2,3,4,5  3,4,5
                    curr.next = next.next; //1,3,4,5   1,4,5
                    next.next = prev.next;//-1,2,1,3,4,5
                    prev.next = next;
                    printLinkedList(next);
                    printLinkedList(curr);
                }
                printLinkedList(prev);
                printLinkedList(curr);
                prev = curr;
            }
    }
    public static void main(String[] args) {
        // 创建一个链表：1 -> 2 -> 3
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = Qusetion25.reverseKGroup(head, 3);
        printLinkedList(listNode);

    }
    public static void printLinkedList(ListNode head) {
        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }
}
