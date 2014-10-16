class Minimum Window Substring{
	public String minWindow(String S, String T) {
        Map<Character,Integer> map1 = new HashMap<Character,Integer>();
        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        for(int i=0;i<T.length();i++){
            if(map1.containsKey(T.charAt(i)))
                map1.put(T.charAt(i),1+map1.get(T.charAt(i)));
            else
                map1.put(T.charAt(i),1);
            if(map2.containsKey(T.charAt(i)))
                map2.put(T.charAt(i),1+map2.get(T.charAt(i)));
            else
                map2.put(T.charAt(i),1);
        }
        int countOfT = T.length();
        int end = 0;
        int start = 0;
        int minStart = 0;
        int minSize = Integer.MAX_VALUE;
        //map1 used to calc the redudent characters abs()
        while(end < S.length()){
            if(map2.containsKey(S.charAt(end))){
                if(map1.get(S.charAt(end)) > 0)
                    countOfT--;
                map1.put(S.charAt(end),map1.get(S.charAt(end))-1);
                //in current substring of s1 all s2 charcters has occured
                if(countOfT == 0){
                    while(start <= end){
                        if(map2.containsKey(S.charAt(start))){
                        	//if the redundent characters in map1 still bigger than 0
                            if(map1.get(S.charAt(start)) < 0)
                                map1.put(S.charAt(start),map1.get(S.charAt(start))+1);
                            //if there is no redundency
                            else
                                break;
                        }
                        start++;
                    }
                    
                    if (minSize > end - start + 1){
                        minStart = start;
                        minSize = end - start + 1;
                    }
                }
            }
            end++;
        }
        if (minSize == Integer.MAX_VALUE)
            return "";
        else{
            return S.substring(minStart,minStart + minSize);
        }
            
    }
}