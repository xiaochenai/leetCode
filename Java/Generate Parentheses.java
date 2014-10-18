class Generate Parentheses{
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> res = new ArrayList<String>();
        genP(n,0,0,res,"");
        return res;
    }
    private void genP(int n, int left, int right, ArrayList<String> res, String curr){
    	if(right == n){
    		res.add(curr);
    		return;
    	}
    	if(left<n){
    		genP(n,left+1,right,res,curr+"(");
    	}
    	if(right<left){
    		genP(n,left,right+1,res,curr+")");
    	}
    }
}