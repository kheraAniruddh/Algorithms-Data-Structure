class ListNode {

	 int val;
     ListNode next;
 	 ListNode(int x) { val = x; }

	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode prev = l1;
        if(l1== null)
            return l2;
        while(cur1!=null && cur2!=null) {
            if(cur1.val > cur2.val) {
                ListNode temp = cur1;
                cur1 = new ListNode(cur2.val);
                cur1.next = temp;
                if(prev!=l1)
                    prev.next = cur1;
                cur2 = cur2.next;
            }
            prev = cur1;
            cur1 = cur1.next;
        }
        if(cur2!=null)
           prev.next= cur2;
    return prev;
   }

   public static void main(String[] args) {
   	ListNode l1 = new ListNode(2);
    ListNode l2 = new ListNode(1);
    ListNode result = mergeTwoLists(l1,l2);
    ListNode cur = result;
    while(cur!=null) {
    	System.out.print(cur.val+" ");
    	cur =cur.next;
    }
   }
}