import java.util.Scanner;
public class LinkedList {

	Node head;

	public class Node {
		int value;
		Node next;
		Node(int value) {
			this.value = value;
			this.next = null;
		}
	}

	public LinkedList() {
		head=null;
	}

	public void append(int n) {
		if(head == null) {
			head = new Node(n);
		}
		else {
		Node current = head;
		while(current.next!=null) 
			current= current.next;
		current.next = new Node(n);
		}
	}

	public void prepend(int n) {
		Node newhead = new Node(n);
		Node cur = head;
		head = newhead;
		head.next =cur;
	}

	public String delete(int n) {
		Node cur = head;
		Node prev = head;


		while(cur.value!=n && cur.next!=null) {
			prev= cur;
			cur = cur.next;
		}
		if(cur == null)
			return "No such element";
		
		if(cur==head)
			head = cur.next;
		else
			prev.next = cur.next;
		return "deleted "+ n;
		}


	public void print() {
		Node current = head;
		while(current!=null) {
			System.out.print(current.value +" ");
			current = current.next;
		}

	}
	
	//Bad way. Since space complexity is O(n)
	public LinkedList badReverse() {
		Node current = head;
		LinkedList rev =  new LinkedList();
		while(current!=null) {
			rev.prepend(current.value);
			current =current.next;
		}
		return rev;
	}


	//Optimized. TC O(n) SC O(1)
	public void reverse() {
		Node cur = head;
		Node prev =null;
		Node next = null;
		while(cur!=null) {
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		head = prev;

	}



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of nos to add");
		int no = Integer.parseInt(sc.nextLine());
		LinkedList list = new LinkedList();
		
		for(int i =0; i<no;i++) {
			list.append(Integer.parseInt(sc.nextLine()));
		}

		// for(int i =0; i<no;i++) {
		// 	list.prepend(Integer.parseInt(sc.nextLine()));
		// }

		// list.print();

		// System.out.println("\n Enter no to delete");
		//System.out.println(list.delete(Integer.parseInt(sc.nextLine())));
		list.print();

		System.out.println("Reversed");
		list.reverse();
		list.print();
}
}