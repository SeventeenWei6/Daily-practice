class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode cur = tmp;
        while(head!=null){

            if(head.val == val){
                cur.next = head.next; 
            }
            else{
                cur = head;
               
            }
            head = head.next;
           
            
        }
        return tmp.next;
    }
}