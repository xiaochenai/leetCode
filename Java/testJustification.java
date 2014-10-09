Class textJustification{
	//add word+" " to line, untile its length exceed L, then count the space we have
	//insert the space evenly between the words, the remain space will be append to the end of line
	// special case: (1)only one word in a line (2)last line
	public List<String> fullJustify(String[] words, int L) {
        List<String> res = new ArrayList<String>();
        if(words == null || words.length == 0)
        	return res;
        int index = 0;
        while(index < words.length){
        	int spaceCount = 0;
        	int size = 0;
        	int newsize = 0;
        	int startIndex = index;
        	while(index < words.length){
        		newsize = size==0?words[index].length():size+words[index].length()+1;//+1 means we add " " to words by default 
        		if(newsize<=L){
        			size = newsize;
        			index++;
        		}
        		else
        			break;
        	}
        	spaceCount = L - size;
        	int intervalSpace = 0, remainSpace = 0;
        	if(index - startIndex>1 && index<words.length){
        		intervalSpace = spaceCount/(index-startIndex-1);
        		remainSpace = spaceCount%(index-startIndex-1);
        	}//if it is not the special case
        	else
        		remainSpace = spaceCount;
        	String temp = "";
        	for(int j = startIndex;j<index;j++){
        		if(j == startIndex)
        			temp = words[startIndex];
        		else{
        			temp = temp + new String(new char[intervalSpace+1]).replace('\0',' ');
        			//if not last line and not only one word in a line, distribute space evenly to words
        			if(remainSpace > 0 && index < words.length){
        				temp = temp + " ";
        				remainSpace--;
        			}
        			temp = temp + words[j];
        		}	
        	}
        	temp = temp + new String(new char[remainSpace]).replace('\0',' ');
        	res.add(temp);
        }
        return res;
    }
}