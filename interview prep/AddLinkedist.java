//Add two linked list
// l1 =       9->2->3->4->5
// l2 =           9->7>8->9
//result = 1->0->2->1->3->4
import java.util.*;

class AddLinkedist {

	Node head;

	class Node {
		int val;
		Node next;
		public Node(int val) {
			this.val =val;
			this.next= null;
		}
	}

	public void add(int val) {
		if(head==null) {
			head = new Node(val);
		}
		else {
			Node cur = head;
			while(cur.next!=null) {
				cur=cur.next;
			}
			cur.next = new Node(val);
		}
	}

	public void print() {
		Node cur =head;
		while(cur!=null) {
			System.out.print(cur.val+" ");
			cur=cur.next;
		}
	}

	public static int findLen(AddLinkedist l) {
		int count =0;
		Node cur = l.head;
		while(cur!=null) {
			count++;
			cur =cur.next;
		}
		return count;
	}


	public static Node reverse(AddLinkedist l) {
		Node new1=l.head, prev1=null;
		while(new1!=null) {
			Node temp = new1.next;
			new1.next = prev1;
			prev1 =new1;
			new1 = temp;

		}
		return prev1;
	}

	public int addRemaining(Node cur, int carry) {
		while(cur!=null) {
			int sum = cur.val+carry;
			if(sum>9) {
				this.add(sum%10);
				carry =1;
			}
			else {
				this.add(sum);
				carry=0;
			}
			cur =cur.next;
		}
		return carry;
	}

	public void computeSum(AddLinkedist l1, AddLinkedist l2) {
		int commonNos =Math.min(findLen(l1), findLen(l2));
		Node rev1 = reverse(l1);
		Node rev2 = reverse(l2);
		int i=0,carry=0;
		while(i<commonNos) {
			int sum = rev1.val+rev2.val+carry;
			if(sum>9) {
				this.add(sum%10);
				carry =1;
			}
			else {
				this.add(sum);
				carry=0;
			}
			rev1 =rev1.next;
			rev2= rev2.next;
			i++;
		}
		if(rev1!=null) {
			carry = this.addRemaining(rev1,carry);
		}
		else if(rev2!=null)
			carry =	this.addRemaining(rev2,carry);

		if(carry!=0)
			this.add(1);
	}

	public static void main(String[] args) {
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		AddLinkedist list1 = new AddLinkedist();
		for(int i=0;i<n;i++)
			list1.add(sc.nextInt());
		int m = sc.nextInt();
		AddLinkedist list2 = new AddLinkedist();
		for(int i=0;i<m;i++)
			list2.add(sc.nextInt());
		AddLinkedist res = new AddLinkedist();
		res.computeSum(list1,list2);
		Node cur = reverse(res);
		while(cur!=null) {
			System.out.print(cur.val+ " ");
			cur=cur.next;
		}
	
	}
}