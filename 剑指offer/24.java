class Solution {
//非递归
    public ListNode reverseList(ListNode head) {
      ListNode cur = null;
      ListNode pre = head;
      while(pre!=null){
          ListNode tmp = pre.next;
          pre.next = cur;
          cur = pre;
          pre = tmp;
      }
      return cur;
    }
    
}
public ListNode reverseList(ListNode head) {
        //递归何时结束？ 当遍历到最后一个节点结束 
        //由于翻转故遍历到倒数第二个节点停止递归
        if(head == null || head.next == null)
         return head;
    
        ListNode ans =  reverseList(head.next);
        //本次递归应该做什么  由于翻转 将当前节点的下一个节点的next指向自己 
        //并将自己的next指为空
        head.next.next = head;
        head.next = null;
        //递归返回值为ans
        return ans;

    }