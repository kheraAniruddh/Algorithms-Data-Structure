import java.util.*;

class BST {
	Node root;

	public class Node {
		int value;
		Node left;
		Node right;
		public Node(int value) {
			this.value = value;
			left =right=null;
		}
	}
	public BST() {
		root= null;
	}

	public void add(int n) {
		if(root==null)
			root= new Node(n);
		else {
			Node cur =root, prev =root;
			while(cur!=null) {
					prev= cur;
				if(n >= cur.value) 
					cur=cur.right;
				else
					cur =cur.left;
			}
			if(n >= prev.value) 
					prev.right = new Node(n);
				else
					prev.left = new Node(n);
		}	
	}


	public void printPreorder(Node cur) {
		if(cur==null) return;
		System.out.print(cur.value+" ");
		this.printInorder(cur.left);
		this.printInorder(cur.right);
	}

	public int maxdepth(Node cur) {
		if(cur==null) return 0;

	}

	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BST tree= new BST();
		for(int i=0;i<n;i++) {
			tree.add(sc.nextInt());
		}
		tree.printPreorder(tree.root);

		System.out.println(tree.maxdepth(tree.root));		
	}
}