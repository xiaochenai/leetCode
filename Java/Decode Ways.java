class Decode Ways{
	public int numDecodings(String s) {
        int n = s.length();
        if (n==0) return 0;
        int[] dp = new int[n+1];
        dp[0] = 1;
        if (isValid(s.substring(0,1))) dp[1] = 1;
        else dp[1] = 0;
        for(int i=2; i<=n;i++){
            if (isValid(s.substring(i-1,i)))
                dp[i] = dp[i-1];
            if (isValid(s.substring(i-2,i)))
                dp[i] += dp[i-2];
        }
        return dp[n];
    }
    
    public boolean isValid(String s){
        if (s.charAt(0)=='0') return false;
        int code = Integer.parseInt(s);
        return code>=1 && code<=26;
    }
}