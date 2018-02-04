
//  Given a Binary Search Tree (BST) with root node root, and a target value V, split the tree into two subtrees where one subtree has nodes that are all smaller or equal to the target value, while the other subtree has all nodes that are greater than the target value.  It's not necessarily the case that the tree contains a node with value V.

// Additionally, most of the structure of the original tree should remain.  Formally, for any child C with parent P in the original tree, if they are both in the same subtree after the split, then node C should still have the parent P.

// You should output the root TreeNode of both subtrees after splitting, in any order.
/*Input: root = [4,2,6,1,3,5,7], V = 2
Output: [[2,1],[4,3,6,null,null,5,7]]
Explanation:
Note that root, output[0], and output[1] are TreeNode objects, not arrays.

The given tree [4,2,6,1,3,5,7] is represented by the following diagram:

          4
        /   \
      2      6
     / \    / \
    1   3  5   7

while the diagrams for the outputs are:

          4
        /   \
      3      6      and    2
            / \           /
           5   7         1
*/
class SplitBST {

  //Definition for a binary tree node.
 public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
   public TreeNode[] splitBST(TreeNode root, int V) {
       TreeNode key = null; 
       TreeNode cur = root;
       TreeNode prev = null;
       TreeNode[] arr = new TreeNode[2]; 
        arr[1] =root;
        arr[0] =key;
       while(cur!=null) {
           if(cur.val > V) {
               prev =cur;
               cur = cur.left;
           }
           else if(cur.val < V) {
               prev = cur;
               cur= cur.right;
           }
           else if(cur.val == V) {
               if(prev!=null) {
                   if(prev.val > cur.val) 
                       prev.left =cur.right;
                   else
                       prev.right = cur.right;
               }
               else
                   arr[1] = cur.right;
               key = new TreeNode(V);
               key.left = cur.left;
               arr[0] =key;
               return arr;
               
           }
       }
       return arr;
    }
}