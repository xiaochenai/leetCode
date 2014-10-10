class Path_Sum_II{
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<ArrayList<Integer>>();
        List<Integer> solution = new ArrayList<Integer>();
        if(root == null)
        	return res;
        genPath(root,0,sum,res,solution);
        //genPath(root,root.val,sum,res,solution);
        return res;
    }
    private void genPath(TreeNode root, int curr, int sum, List<List<Integer>> res,List<Integer> solution){
    	curr += root.val;
    	solution.add(root.val);
    	if(root.left == null && root.right == null && curr == sum){
    		List<Integer> temp = new ArrayList<Integer>(solution);
    		res.add(temp);
    		solution.remove(solution.size()-1);
    		return;
    	}
    	if(root.left != null){
    		genPath(root.left,curr,sum,res,solution);
    	}
    	if(root.right != null){
    		genPath(root.right,curr,sum,res,solution);
    	}
    	solution.remove(solution.size()-1);
    }private void genPath(TreeNode root, int curr, int sum, List<List<Integer>> res,List<Integer> solution){
    	if(root.left == null && root.right == null && curr == sum){
    		List<Integer> temp = new ArrayList<Integer>(solution);
    		res.add(temp);
    		return;
    	}
    	if(root.left != null){
    		solution.add(root.left);
    		genPath(root.left,curr+root.left.val,sum,res,solution);
    		solution.remove(solution.size()-1);
    	}
    	if(root.right != null){
    		solution.add(root.left);
    		genPath(root.right,curr+root.right.val,sum,res,solution);
    		solution.remove(solution.size()-1);
    	}
    }
}