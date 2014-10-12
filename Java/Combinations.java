class Combinations{
	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> sol = new ArrayList<Integer>();
		genCom(n,k,1,sol,res);
		return res;
	}
	private void genCom(int n,int k,int level,ArrayList<Integer> sol,ArrayList<ArrayList<Integer>> res){
		if(sol.size() == k){
			res.add(new ArrayList<Integer>(sol));
			return;
		}
		for(int i=level;i<=n;i++){
			sol.add(i);
			genCom(n,k,i+1,sol,res);
			sol.remove(sol.size()-1);
		}
	}
}