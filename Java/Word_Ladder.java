class Word_Ladder{
	public int ladderLength(String start, String end, Set<String> dict) {
        if(start == null || end == null)
        	return 0;
        LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
        LinkedList<String> interWordQueue = new LinkedList<String>();
        interWordQueue.offer(start);
        distanceQueue.offer(1);
        while(!interWordQueue.isEmpty()){
        	String temp = interWordQueue.poll();
        	int distance = distanceQueue.poll();
        	for(int i=0;i<temp.length();i++){
        		for(char c='a';c<='z';c++){
        			char[] charArray = temp.toCharArray();
        			if(c != charArray[i]){
        				charArray[i] = c;
        				String tempString = new String(charArray);
        				if(tempString.equals(end)){
        					return distance+1;
        				}
        				if(dict.contains(tempString)){
        					interWordQueue.offer(tempString);
        					distanceQueue.offer(distance+1);
        					dict.remove(tempString);
        				}
        			}
        		}
        	}
        }
        return 0;
    }
}