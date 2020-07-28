class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if(head == null || k == 0) return null;
        ListNode  former = head;
        ListNode  latter = head;
        for(int i = 0;i < k;i++){
            if(former == null) return null;
            former = former.next;
        }
        while(former !=null){
            former = former.next;
            latter = latter.next;
        }
        return latter;
    }
}