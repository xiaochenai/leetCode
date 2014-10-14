class Binary Tree Zigzag Level Order Traversal{
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null)
        	return res;
        int level = 1;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
        	int size = stack.size();
        	ArrayList<Integer> solution = new ArrayList<Integer>();
        	ArrayList<TreeNode> treeArray = new ArrayList<TreeNode>();
        	for(int i=0;i<size;i++){
        		treeArray.add(stack.pop());
        	}
        	for(TreeNode t:treeArray){
        		if(level%2 == 1){
        			solution.add(t.val);
        			if(t.left != null)
        				stack.push(t.left);
        			if(t.right != null)
        				stack.push(t.right);
        		}
        		else{
					solution.add(t.val);
        			if(t.right != null)
        				stack.push(t.right);
        			if(t.left != null)
        				stack.push(t.left);
        		}
        	}
        	level = (level+1)%2;
        	res.add(solution);
        }
        return res;
	}
}