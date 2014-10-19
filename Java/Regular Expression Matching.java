class Regular Expression Matching{
	public boolean isMatch(String s, String p) {
 
        if(p.length() == 0)
            return s.length() == 0;
 
        //p's length 1 is special case    
        if(p.length() == 1 || p.charAt(1) != '*'){
            if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
                return false;
            return isMatch(s.substring(1), p.substring(1));    
 
        }
        //p.length() > 1 && p.charAt(1) == '*'
        else{
            int len = s.length();
 
            int i = -1; 
            //i == -1 means * match zero character, so start from 2
            //then i == 0; if s(0) do not match p(0) then return false
            while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
                if(isMatch(s.substring(i+1), p.substring(2)))
                    return true;
                i++;
            }
            return false;
        } 
    }
}