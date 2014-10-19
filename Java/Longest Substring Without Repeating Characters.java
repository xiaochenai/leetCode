class Longest Substring Without Repeating Characters{
	//use a map
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		int startIndex = 0;
		int currIndex = 0;
		int maxLen = 1;
        if(s == null || s.length() == 0)
            return 0;
        while(currIndex < s.length()){
        	if(map.containsKey(s.charAt(currIndex)) && map.get(s.charAt(currIndex)) >= startIndex){
        		startIndex = map.get(s.charAt(currIndex))+1;
        	}
        	map.put(s.charAt(currIndex),currIndex);
        	maxLen = Math.max(maxLen,currIndex-startIndex+1);
        	currIndex++;
        }
        return maxLen;
	}
}