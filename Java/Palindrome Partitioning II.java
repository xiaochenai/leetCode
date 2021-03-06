class Palindrome Partitioning II{
	public int minCut(String s) {
        int min = 0;
        int len = s.length();
        boolean[][] matrix = new boolean[len][len];
        int[] cuts = new int[len+1];
        if(s == null || s.length() == 0)
        	return 0;
        for(int i=0;i<len;i++){
        	cuts[i] = len-i;
        }
        for(int i=len-1;i>=0;i--){
        	for(int j=i;j<len;j++){
        		if((s.charAt(i) == s.charAt(j) && (j-i)<2) || (s.charAt(i) == s.charAt(j) && matrix[i+1][j-1])){
        			matrix[i][j] = true;
        			cuts[i] = Math.min(cuts[i],cuts[j+1]+1);
        		}
        	}
        }
        min = cuts[0];
        return min-1;
    }
    // use matrix[][] to record whether s(i...j) is palindrome
    // use cuts[] to record the min cuts from s(i...s.length)
    public int minCut(String s) {
        int min = 0;
        int len = s.length();
        int[][] matrix = new int[len][len];
        int[] cuts = new int[len+1];
        for(int i=0;i<len;i++){
            cuts[i] = len-i;
        }
        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(s.charAt(i) == s.charAt(j) && (j-i)<2 || s.charAt(i) == s.charAt(j) && matrix[i+1][j-1]){
                    matrix[i][j] == true;
                    cuts[i] = Math.min(cuts[i],curs[j+1]+1);
                }
            }
        }
        min = cuts[0];
        return min-1;
    }
}