class Path Sum II{
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sol = new ArrayList<Integer>();
		if(root == null)
			return res;
		sol.add(root.val);
		findPath(root,res,sol,sum,root.val);
		return res;
	}
	private void findPath(TreeNode root, ArrayList<ArrayList<Integer>> res, 
					ArrayList<Integer> sol, int sum, int curr){
		if(curr == sum && root.left == null && root.right == null){
			res.add(new ArrayList<Integer>(sol));
			return;
		}
		if(root.left != null){
			sol.add(root.left.val);
			findPath(root.left,res,sol,sum,curr+root.left.val);
			sol.remove(sol.size()-1);
		}
		if(root.right != null){
			sol.add(root.right.val);
			findPath(root.right,res,sol,sum,curr+root.right.val);
			sol.remove(sol.size()-1);
		}
	}
} 