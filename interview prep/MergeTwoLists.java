/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode cur1 = l1;
      ListNode cur2 = l2;
      ListNode prev = null;
      if(l1==null)
          return l2;
      while(cur1 != null && cur2 != null) {
          if(cur1.val > cur2.val) {
              ListNode temp =  cur1;
              cur1 = new ListNode(cur2.val);
              cur1.next = temp;
              cur2 = cur2.next;
              if(prev !=null)
                 prev.next= cur1;
              else
                  l1 = cur1;
          }
        prev = cur1;
        cur1 = cur1.next;   
      }
      if(cur2!=null) {
         cur1 = prev;
         cur1.next= cur2;
      }
      return l1;  
    }
}
