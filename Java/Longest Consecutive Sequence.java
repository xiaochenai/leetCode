class Longest Consecutive Sequence{
	//use a map
    public int longestConsecutive(int[] num) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int max = 0;
        for(int i=0;i<num.length;i++){
        	if(map.containsKey(num[i]))
        		map.put(num[i],map.get(num[i])+1);
        	else
        		map.put(num[i],1);
        }
        for(int i=0;i<num.length;i++){
        	if(map.get(num[i]) == 0)
        		continue;
        	int curr = 1;
        	int start = num[i] + 1;
        	while(true){
        		if(map.containsKey(start)){
        			curr += 1;
        			map.put(start,0);
        			start++;
        		}
        		else
        			break;
        			
        	}
        	start = num[i] - 1;
        	while(true){
        		if(map.containsKey(start)){
        			curr += 1;
        			map.put(start,0);
        			start--;
        		}
        		else
        			break;
        	}
        	max = Math.max(max,curr);
        }
        return max;
    }	
}