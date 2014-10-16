class Subsets{
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        if(S == null || S.length == 0)
            return res;
        Arrays.sort(S);
        recursive(S,res,solution,0);
        res.add(new ArrayList<Integer>());
        return res;
	}
	private void recursive(int[] S, ArrayList<ArrayList<Integer>> res, 
			ArrayList<Integer> solution, int level){
		if(level == S.length){
			return;
		}
		for(int i=level;i<S.length;i++){
			solution.add(S[i]);
			res.add(new ArrayList<Integer>(solution));
			recursive(S,res,solution,i+1);
			solution.remove(solution.size()-1);
		}
	}
	private ArrayList<ArrayList<Integer>> iterativeSolution(int[] S){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<S.length;i++){
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> al:res)
				temp.add(new ArrayList<Integer>(al));
			for(ArrayList<Integer> al:temp){
				al.add(S[i]);
			}
			ArrayList<Integer> a = new ArrayList<Integer>();
			a.add(S[i]);
			res.add(a);
			res.addAll(temp);
		}
		res.add(new ArrayList<Integer>());
        return res;
	}
}