class Solution {
    //双指针
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        ListNode  pre = head;
        ListNode  cur = head.next;
        while(cur != null && cur.val != val){
            pre = cur;
            cur = cur.next;
        } 
        pre.next = cur.next;
        return head;
    }
}