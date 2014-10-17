class Permutations II{
	public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<Integer> sol = new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0)
        	return res;
        int[] visited = new int[num.length];
        Arrays.sort(num);
        genPermute(num,visited,sol,res);
        return res;
    }
    private void genPermute(int[] num,int[] visited, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
    	if(sol.size() == num.length){
    		res.add(new ArrayList<Integer>(sol));
    		return;
    	}
    	for(int i=0;i<num.length;i++){
    		if(visited[i] == 0){
    			if(i>0 && num[i] == num[i-1] && visited[i-1] == 0)
    				continue;
    			visited[i] = 1;
    			sol.add(num[i]);
    			genPermute(num,visited,sol,res);
    			sol.remove(sol.size()-1);
    			visited[i] = 0;
    		}
    	}
    }
} 