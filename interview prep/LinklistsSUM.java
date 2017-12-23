import java.util.*;

class LinklistsSum {

	Node head;

	class Node {
		int value;
		Node next;
		public Node(int value){
			this.value = value;
			next =null;
		}

	public LinklistsSum() {
		head= null;
	}


	public void add(int n) {
		if(head==null)
			head = new Node(n);
		else {
			Node cur = head;
			while(cur.next!=null) {
				cur=cur.next;
			}

			cur.next= new Node(n);
		}
	}


	public Node computeSum(Node head1, Node head2) {

		if(head1==null)
			return head2;
		if(head2==null)
			return head1;
		
		if(getSize(head1, head2)< 0)
			//l2 bigger move head2 to their diff
		else {
			if(getSize(head1,head2>0))
				//l1 is bigger move head 1 to their diff
			else
				//	
		}	
	}

	int getSize(Node head1, Node head2) {
		Node cur1 = head1, cur2= head2;
		int size1=1,size2=1;
		while(cur1!=null) {
			cur1= cur1.next;
			size1++;
		}
		while(cur2!=null) {
			cur2= cur2.next;
			size2++;
		}

		return size1-size2;
	}


}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		LinklistsSum l1 = new LinklistsSum();
		for(int i=0;i<n1;i++)
			l1.add(sc.nextInt());

		int n2 = sc.nextInt();
		LinklistsSum l2 = new LinklistsSum();
		for(int i=0;i<n2;i++)
			l2.add(sc.nextInt());		
		
	}
}