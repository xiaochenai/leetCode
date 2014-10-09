/*des:Given a string S, find the longest palindromic substring in S. 
You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring*/
public class Longest Palindromic Substring{
	private int startIndex = 0;
	private int width = 0;
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