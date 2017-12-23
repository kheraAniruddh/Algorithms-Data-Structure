import java.util.*;

class SinglLinkl {
	Node head;

	public SinglLinkl() {
		head =null;
	}

	public class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value =value;
			next=null;
		}
	}

	public void add(int n) {
		if(head==null)
			head = new Node(n);
		else {
			Node cur = head;
			while(cur.next!=null) {
				cur=cur.next;
			}
			cur.next = new Node(n);
		}
	}

	public void print() {
		Node cur =head;
		while(cur!=null){
			System.out.print(cur.value+ " ");
			cur=cur.next;
		}
	}

	public void reverse(Node cur) {
		if(cur==null)
			return ;
		reverse(cur.next);
		System.out.print(cur.value+" ");
	}

	public void makeCircular() {
		Node cur = head;
			while(cur.next!=null) {
				cur=cur.next;
			}
			cur.next = head.next;
	}


public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	SinglLinkl sl = new SinglLinkl();
	for(int i=0;i<n;i++) 
		sl.add(sc.nextInt());
	s1.makeCircular();
//	sl.print();
	s1.findCircular();
	System.out.println();
	//sl.reverse(sl.head);

	System.out.println();

	}
}


