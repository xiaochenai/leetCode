class Word_Break{
	public boolean wordBreak(String s, Set<String> dict) {
        s = "#" + s;
        boolean[] dp = new boolean[s.length()];
        dp[0] = true;
        for(int i=1;i<s.length();i++){
        	for(int j=0;j<i;j++){
        		dp[i] = dp[j] && dict.contains(s.substring(j+1,i+1));
        		if(dp[i]) break;
        	}
        }
        return dp[s.length()-1];
    }
    public boolean wordBreak(String s, Set<String> dict) {
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
    public boolean wordBreak(String s, Set<String> dict) {
    	boolean[] dp = new boolean[s.length()+1];
    	dp[0] = true;
    	for(int i=0;i<s.length();i++){
    		if(!dp[i]) continue;
    		for(String ss:dict){
    			int end = i+ss.length();
    			if(end > s.length())
    				continue;
    			if(dp[end])
    				continue;
    			dp[end] = s.substring(i,end).equals(ss);
    		}
    	}
    	return dp[s.length()];
    }
}