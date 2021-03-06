class Permutations{
	public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sol = new ArrayList<Integer>();
        if(num == null || num.length == 0)
        	return res;
        int[] visited = new int[num.length];
        genPermute(num,visited,sol,res);
        return res;
    }
    private void genPermute(int[] num, int[] visited, ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res){
    	if(sol.size() == num.length){
    		res.add(new ArrayList<Integer>(sol));
    		return;
    	}
    	for(int i=0;i<num.length;i++){
    		if(visited[i] == 0){
    			visited[i] = 1;
    			sol.add(num[i]);
    			genPermute(num,visited,sol,res);
    			visited[i] = 0;
    			sol.remove(sol.size()-1);
    		}
    	}
    }
}