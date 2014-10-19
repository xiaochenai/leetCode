class Longest Palindromic Substring{
	private int startIndex = 0;
	private int width = 0;
	//for any character search from current character to left and right untile find left != right
	//track the index of left and the length
	public String longestPalindrome(String s) {
        for(int i=0;i<s.length()-1;i++){
        	if(s.charAt(i) == s.charAt(i+1)){
        		search(i,i+1,s);
        	}
        	search(i,i,s);
        }
        if(s.length() == 1 || s.length() == 0)
        	width = s.length();
        return s.substring(startIndex,startIndex + width);
    }
    private void search(int left, int right, String s){
    	int step = 1;
    	while((left-step)>=0 && (right+step)<s.length()){
    		if(s.charAt(left-step) != s.charAt(right+step)){
    			break;
    		}
    		step++;
    	}
    	int temp = 2*step-1+right-left;
    	if(temp>this.width){
    		this.width = temp;
    		startIndex = left-step+1;
    	}
    }
}