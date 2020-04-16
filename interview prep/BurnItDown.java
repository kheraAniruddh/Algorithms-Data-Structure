 import java.util.*;

 public class BurnItDown {
 	public class Node {
       int value;
       Node left;
       Node right;
    	Node(int value) {
    		this.value =value;
    	}
  	}

  	public  List<List<Integer>> getTreeBurningSequence(Node root, int target, boolean isBurning) {
  		List<List<Integer>> res = new ArrayList<>();
  		Map<Integer, Node> ancestorMap = new HashMap<>();// since value is unique as interpreted from the question, otherwise use Node
  		Set<Integer> burnt = new HashSet<>(); // since value is unique as interpreted from the question, otherwise use Node
  		Node targetNode = null;
  		
  		traverseAndUpdateMap(root, ancestorMap);
  		if(!ancestorMap.containsKey(target))
  			return res;
  		else {
  			Node parent = ancestorMap.get(target);
  			if(parent.left!=null && parent.left.value==target)
  				targetNode = parent.left;
  			else
  				targetNode = parent.right;
  		}
  		Queue<Node> queue = new LinkedList<>();
  		queue.add(targetNode);
  		
  		while(!queue.isEmpty()) {
  			int size = queue.size(), i=0;
  			List<Integer> temp = new ArrayList<>();
  			while(i<size) {
  				Node cur = queue.remove();
  				burnt.add(cur.value);
  				temp.add(cur.value);
  				i++;
  				if(cur.left!=null && !burnt.contains(cur.left.value))
  					queue.add(cur.left);
  				if(cur.right!=null && !burnt.contains(cur.right.value))
  					queue.add(cur.right);
  				if(ancestorMap.containsKey(cur.value) && !burnt.contains(ancestorMap.get(cur.value).value))
  					queue.add(ancestorMap.get(cur.value));
  			}
  			res.add(temp);		
  		}
  		return res;
  	}

  	public void traverseAndUpdateMap(Node cur, Map<Integer, Node> map) {
  		if(cur!=null) {
  			if(cur.left!=null) 
  				map.put(cur.left.value, cur);
  			if(cur.right!=null)
  				map.put(cur.right.value, cur); 
  			traverseAndUpdateMap(cur.left, map);
  			traverseAndUpdateMap(cur.right, map);
  		}
  		return;
  	}
  	
 	public static void main(String[] args) {
		BurnItDown burnItDown = new BurnItDown();
 		BurnItDown.Node root = burnItDown.new Node(12);
 		root.left = burnItDown.new Node(13);
 		root.right = burnItDown.new Node(10);
 		root.right.left = burnItDown.new Node(14);
 		root.right.right = burnItDown.new Node(15);
 		root.right.left.left = burnItDown.new Node(21);
 		root.right.left.right= burnItDown.new Node(24);
 		root.right.right.left = burnItDown.new Node(22);
 		root.right.right.right = burnItDown.new Node(23);

		List<List<Integer>> res = burnItDown.getTreeBurningSequence(root, 14, true);
		res.stream().forEach(System.out::println);

	}
}