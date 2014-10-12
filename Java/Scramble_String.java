class Scramble_String{
	public boolean isScramble(String s1, String s2) {
        return recureive(s1,s2);
    }
    private boolean recursive(String s1,String s2){
    	if(s1.length() != s2.length())
    		return false;
    	if(s1.equals(s2))
    		return true;
    	int[] chars = new int[26];
    	for(int i=0;i<s1.length();i++){
    		chars[(s1.charAt(i)-'a')]--;
    		chars[(s2.charAt(i)-'a')]++;
    	}
    	for(int i:chars){
    		if(i != 0)
    			return false;
    	}
    	for(int i=1;i<s1.length();i++){
    		String s11 = s1.substring(0,i);
    		String s12 = s1.substring(i,s1.length());
    		String s21 = s2.substring(0,i);
    		String s22 = s2.substring(i,s1.length());
    		if(recursive(s11,s21) && recursive(s12,s22))
    			return true;
    		s21 = s2.substring(0,s2.length()-i);
    		s22 = s2.substring(s2.length()-i,s2.length());
    		if(recursive(s11,s22) && recursive(s12,s21))
    			return true;
    	}
    	return false;
    }
    //What scramble[k][i][j] means is that two substrings of length k+1, 
    //one starts from i of string s1, another one starts from j of string s2, are scramble
    //trying to find scramble[L][0][0]
    private boolean dp(String s1, String s2){
    	if(s1.length() != s2.length())
    		return false;
    	if(s1.equals(s2))
    		return true;
    	int L = s1.length();
    	boolean[][][] scramble = new boolean[L][L][L];
    	for(int i=0;i<L;i++){
    		for(int j=0;j<L;j++){
    			if(s1.charAt(i) == s2.charAt(j))
    				scramble[0][i][j] = true;
    		}
    	}
    	for(int k=2;k<=L;k++){
            //change the order
    		for(int i=L-k;i>=0;i--){
    			for(int j=L-k;j>=0;j--){
    				boolean canScramble = false;
    				for(int m = 1;m<k;m++){
    					canScramble = (scramble[m - 1][i][j] && scramble[k - m - 1][i + m][j + m]) 
    					|| (scramble[m - 1][i][j + k -m] && scramble[k - m - 1][i + m][j]);
    					if(canScramble)
    						break;
    				}
    				scramble[k - 1][i][j] = canScramble;
    			}
    		}
    	}
    	return scramble[L - 1][0][0];
    }
}