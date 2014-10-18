class Substring with Concatenation of All Words{
	public List<Integer> findSubstring(String S, String[] L) {
        int lenOfS = S.length();
        int lenOfL = L.length;
        int lenOfElementsInL = L[0].length();
        boolean exist = false;
        ArrayList<Integer> startIndex = new ArrayList<Integer>();
        for(int i=0;i<lenOfS-lenOfL*lenOfElementsInL+1;i++){
        	exist = true;
        	ArrayList<String> subOfS = new ArrayList<String>();
        	for(int j=i;j<i+lenOfL*lenOfElementsInL;j+=lenOfElementsInL){
        		subOfS.add(S.substring(j,j+lenOfElementsInL));
        	}
        	for(String s:L){
        		if(!subOfS.contains(s)){
        			exist = false;
        			break;
        		}
        		else{
        			subOfS.remove(s);
        		}
        	}
        	if(exist){
        		startIndex.add(i);
        	}
        }
        return startIndex;
    }
}