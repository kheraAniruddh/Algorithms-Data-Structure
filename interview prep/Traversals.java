import java.util.*;
class Traversals {

	public static List<Integer> inorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		Stack<TreeNode> stack = new Stack<>();
		// stack.push(root);
		TreeNode cur = root;
		while(cur!=null || !stack.isEmpty()) {
			while(cur!=null) {
				stack.push(cur);
				cur =cur.left;
			}
			if(!stack.isEmpty()) {
				cur = stack.pop();
				res.add(cur.val);
				cur =cur.right;
			}
		}
		return res;

	}

	public static List<Integer> preorder(TreeNode root) {
		List<Integer> res = new ArrayList<>();
		if(root==null) return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur =root;
		while(cur!null || !stack.isEmpty()) {
			while(cur!=null) {
				res.add(cur.val);
				stack.push(cur);
				cur=cur.left;
			}
			if(!stack.isEmpty()) 
				cur = stack.pop().right;
		}
		return res;

	}

	public static List<Integer> postorder(TreeNode root) {
		 List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root == null) return res;
        TreeNode cur = root, prev=null;
        stack.push(cur);
         while( !stack.isEmpty()) {
            cur = stack.peek();
            if(prev == null || prev.left == cur || prev.right == cur) { 
                if(cur.left!=null) stack.push(cur.left);
                else if(cur.right!=null) stack.push(cur.right);
                else {
                    cur = stack.pop();
                    res.add(cur.val);
                }
            }
             else if(cur.left==prev) {
                 if(cur.right!=null)
                    stack.push(cur.right); 
                else 
                { 
                    stack.pop(); 
                    res.add(cur.val); 
                } 
             }
             else if(cur.right==prev) {
                    stack.pop(); 
                    res.add(cur.val); 
             }
            prev =cur; 
                    
        }
        return res;
	}




	public static void main(String[] args) {
		System.out.println(Traversals.inorder(root));
		System.out.println(Traversals.preorder(root));
		System.out.println(Traversals.postorder(root));
	}
}