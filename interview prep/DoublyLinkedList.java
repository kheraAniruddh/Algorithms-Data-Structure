import java.util.Scanner;
public class DoublyLinkedList {

	Node head;


	class Node {
		int value;
		Node next;
		Node prev;

		public Node(int n) {
			this.value = n;
			this.next = null;
		}
	}

	public void add(int n) {
		Node cur = head;
		Node pr = head;

		if(head==null)
			head = new Node(n);
		else{
			while(cur.next!=null) {
				pr = cur;
				cur = cur.next;
			}
			cur.next = new Node(n);
			cur.next.prev = cur;
		}
	}

	public void print() {
		Node cur = head;
		while(cur!=null){
			System.out.print(cur.value);
			cur =cur.next;
		}
	}

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of nos to add");
		int no = Integer.parseInt(sc.nextLine());
		DoublyLinkedList list = new DoublyLinkedList();
		for(int i =0;i<no;i++) {
			list.add(Integer.parseInt(sc.nextLine()));
		}
		list.print();
	}
}