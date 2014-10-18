class Longest Common Prefix{
	public String longestCommonPrefix(String[] strs) {
		 if(strs == null || strs.length == 0)
            return "";
        String res = strs[0];
        for(int i=1;i<strs.length;i++){
        	String temp = "";
        	int index = 0;
        	while(index < res.length() && index< strs[i].length()){
        		if(res.charAt(index) == strs[i].charAt(index)){
        			temp = temp + res.charAt(index);
        			index++;
        		}
        		else
        			break;
        	}
        	res = temp+"";
        }
        return res;
	}
}