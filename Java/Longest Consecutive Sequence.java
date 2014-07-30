public class Solution {
    public int longestConsecutive(int[] num) {
        HashMap<Integer,Boolean> dict = new HashMap<Integer,Boolean>();
		for(int i=0;i<num.length;i++){
			dict.put(num[i],false);
		}
		int maxLen=0;
		int tempMaxLen=0;
		int i = 0;
		for (int e:num){
			if (dict.get(e)==false){
				dict.put(e,true);
				tempMaxLen = 1;
				i = e + 1;
				while (dict.containsKey(i) && dict.get(i)==false){
					dict.put(i,true);
					tempMaxLen += 1;
					i+=1;
				}
				i = e-1;
				while(dict.containsKey(i) && dict.get(i)==false){
					dict.put(i,true);
					tempMaxLen+=1;
					i-=1;
				}
			}
			maxLen = Math.max(tempMaxLen,maxLen);
		}
		return maxLen;
    }
}