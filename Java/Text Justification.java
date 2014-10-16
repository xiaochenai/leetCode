class Text Justification{
	public List<String> fullJustify(String[] words, int L) {
        ArrayList<String> res = new ArrayList<String>();
        int curr = 0;
        if(words == null || words.length == 0)
        	return res;
        while(curr < words.length){
        	int spaceCount = 0;
        	int size = 0;
        	int newSize = 0;
        	int start = curr;
        	while(curr < words.length){
        		newSize = size == 0?words[curr].length():size+words[curr].length()+1;
        		if(newSize > L){
        			break;
        		}
        		else{
        			size = newSize;
        			curr++;
        		}
        	}
        	spaceCount = L - size;
        	int interSpaceCount = 0;
        	int remainSpaceCount = 0;
        	if(curr - start  > 1 && curr < words.length){
        		interSpaceCount = spaceCount/(curr-start-1);
        		remainSpaceCount = spaceCount%(curr-start-1);
        	}
        	else
        		remainSpaceCount = spaceCount;
        	int i = start;
        	String temp = "";
        	while(i<curr){
        		if(i == start){
        			temp = words[i];
        			i++;
        		}
        		else{
        			temp = temp + new String(new char[interSpaceCount+1]).replace('\0',' ');
        			if(remainSpaceCount > 0 && curr<words.length){
        				temp = temp + " ";
        				remainSpaceCount--;
        			}
        			temp = temp + words[i];
        			i++;
        		}
        	}
        	temp = temp + new String(new char[remainSpaceCount]).replace('\0',' ');
        	res.add(temp);
        }
        return res;
    }
}