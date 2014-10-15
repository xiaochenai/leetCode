class Subsets II{
	public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> solution = new ArrayList<Integer>();
        if(num == null || num.length == 0)
            return res;
        Arrays.sort(num);
        findSubsets(solution,res,0,num);
        res.add(new ArrayList<Integer>());
        return findSubsetsIterative(num);
	}
	private void findSubsets(ArrayList<Integer> solution, 
		ArrayList<ArrayList<Integer>> res, int level, int[] num){
		if(level == num.length)
			return;
		for(int i=level;i<num.length;i++){
			if(i<num.length-1&&num[i] == num[i+1])
				continue;
			solution.add(num[i]);
			res.add(new ArrayList<Integer>(solution));
			findSubsets(solution,res,i+1,num);
			solution.remove(solution.size()-1);
		}

	}
	private ArrayList<ArrayList<Integer>> findSubsetsIterative(int[] num){
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<num.length;i++){
			if(i == 0 || prev.size() == 0 || num[i] != num[i-1]){
				prev = new ArrayList<ArrayList<Integer>>();
                for(int j=0;j<res.size();j++){
                    prev.add(new ArrayList<Integer>(res.get(j)));
                }
			}
			for(ArrayList<Integer> a:prev){
				a.add(num[i]);
			}
			if(i == 0 || num[i] != num[i-1]){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(num[i]);
                prev.add(temp);
            }
            for(ArrayList<Integer> s:prev){
                res.add(new ArrayList<Integer>(s));
            }

		}
		res.add(new ArrayList<Integer>());
        return res;
	}
}