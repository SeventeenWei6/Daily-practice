public class Solution {
    public boolean hasCycle(ListNode head) {
        if( head==null ||head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow ){
            //只要快指针到达链表尾部，则无环
        if (fast == null || fast.next == null) {
            return false;
        }
        fast = fast.next.next;
        slow = slow.next;
        }
        return true;
    }
}