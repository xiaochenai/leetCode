class Combination Sum{
	public ArrayList<ArrayList<Integer>> combinationSum(int[] num, int target) {
		Arrays.sort(num);
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> sol = new ArrayList<Integer>();
        genCom(sol,res,num,target,0,0);
        return res;
    }
    private void genCom(ArrayList<Integer> sol, ArrayList<ArrayList<Integer>> res, int[] num, int target, int curr,int level){
    	if(target == curr){
    		res.add(new ArrayList<Integer>(sol));
    		return;
    	}
    	if(curr > target)
    		return;
    	for(int i=level;i<num.length;i++){
    		sol.add(num[i]);
    		genCom(sol,res,num,target,curr+num[i],i);
    		sol.remove(sol.size()-1);
    	}
    }
}