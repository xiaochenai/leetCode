class wildmatch{
public boolean isMatch(String s, String p) {  
        int i = 0;  
        int j = 0;  
        int star = -1;  
        int mark = -1;  
        //greedy strategy
        //match as much as possible
        //if failed go back to find * and rematch from *
        while (i < s.length()) {  
            if (j < p.length()  && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {  
                ++i;  
                ++j;  
            } else if (j < p.length() && p.charAt(j) == '*') {  
                star = j++; //start used to record the index of '*'
                mark = i;  //used to record the current index of the matches for '*'
            } else if (star != -1) {  
            	//if there is a previous * and current match failed
            	//match * as short as possible
            	//if any p(j) math failed(p(j)!=s(i) && p(j)!= '*'or'?') then
            	//match s(i) into the '*' 
                j = star + 1;//re-match characters after *
                i = ++mark;  //record current last character index matched for *
            } else {  
                return false;  
            }  
        }  
        while (j < p.length() && p.charAt(j) == '*') {  
            ++j;  
        }  
        return j == p.length();  
    }  
}