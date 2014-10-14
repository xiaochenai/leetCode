class Recover Binary Search Tree{
	//left root right
	//two neighbor nodes swap:
	//fron > back
	//non neighbor:
	//fron>back * 2
	public void recoverTree(TreeNode root) {
        ArrayList<TreeNode> res = new ArrayList<TreeNode>();
        ArrayList<TreeNode> pre = new ArrayList<TreeNode>();
        findSwap(root,res,pre);
        if(res.size()!=0){
        	int v = res.get(0).val;
        	res.get(0).val = res.get(1).val;
        	res.get(1).val = v;
        }
    }
    private void findSwap(TreeNode root, ArrayList<TreeNode> res, ArrayList<TreeNode> pre){
    	if(root == null)
    		return;
    	findSwap(root.left,res,pre);
    	if(pre.size() != 0 && root.val < pre.get(0).val){
    		if(res.size() == 0){
    			res.add(pre.get(0));
    			res.add(root);
    		}
    		else{
    			res.set(1,root);
    		}
    	}
    	if(pre.size() == 0)
    		pre.add(root);
    	else
    		pre.set(0,root);
    	findSwap(root.right,res,pre);


    }
}