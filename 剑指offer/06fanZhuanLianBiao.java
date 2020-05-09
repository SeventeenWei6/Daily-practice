/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    ArrayList<Integer> list = new ArrayList<>();
    public int[] reversePrint(ListNode head) {
        digui(head);
        int tmp[] = new int[list.size()];
        for (int i =  0;i<tmp.length;i++)
        {
            tmp[i] = list.get(i);
        }
        return  tmp;
    }
    public void digui(ListNode head){
        if (head==null)
            return;
        digui(head.next);
        list.add(head.val);
    }
}