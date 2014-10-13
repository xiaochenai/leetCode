class Word_Break_II{
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> res = new ArrayList<String>();
        breakWord(res,dict,"",s);
        return res;
    }
    private void breakWord(ArrayList<String> res, Set<String> dict,String curr,String s){
    	if(s.length() == 0){
    		res.add(curr);
    		return;
    	}
    	if(breakable(s,dict)){
    		for(int i=1;i<=s.length();i++){
    			if(dict.contains(s.substring(0,i))){
    				String temp = curr==""?s.substring(0,i):curr+" "+s.substring(0,i);
    				breakWord(res,dict,temp,s.substring(i));
    			}
    		}
    	}
    }
    private boolean breakable(String s,Set<String> dict){
    	boolean[] dp = new boolean[s.length()+1];
    	dp[0] = true;
    	for(int i=1;i<=s.length();i++){
    		for(int j=0;j<i;j++){
    			dp[i] = dp[j] && dict.contains(s.substring(j,i));
    			if(dp[i]) break;
    		}
    	}
    	return dp[s.length()];
    }	
}