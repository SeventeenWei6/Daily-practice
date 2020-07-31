class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        //快慢指针 当fast走完时 若为奇数个节点，则slow刚好走一中间。若为偶数，则走到后半段第一个
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        //翻转后半段
        fast = slow;
        slow = head;
        ListNode cur = null;
        while(fast !=null){
            ListNode tmp = fast.next;
            fast.next = cur;
            cur =  fast;
            fast =tmp;
        }
        while(head!=null &&cur!=null){
            if(head.val != cur.val) return false;
            head = head.next;
            cur = cur.next;
            
        }
        return true;
    }
}