class Unique Binary Search Trees II{
	//for every root node generate all possible left subtree and right subtree
	//combine togetger
	public List<TreeNode> generateTrees(int n) {
		if (n == 0)
            return genSubTree(1,0);
        return genSubTree(1,n);
    }
    private ArrayList<TreeNode> genSubTree(int start, int end){
    	ArrayList<TreeNode> subTree = new ArrayList<TreeNode>();
    	if(start > end){
    		subTree.add(null);
    		return subTree;
    	}
    	for(int i=start;i<=end;i++){
    		ArrayList<TreeNode> left = genSubTree(start,i-1);
    		ArrayList<TreeNode> right = genSubTree(i+1,end);
    		for(int j=0;j<left.size();j++){
    			for(int k=0;k<right.size();k++){
    				TreeNode root = new TreeNode(i);
    				root.left = left.get(j);
    				root.right = right.get(k);
    				subTree.add(root);
    			}
    		}
    	}
    	return subTree;
    }
}