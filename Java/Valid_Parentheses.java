class Valid_Parentheses{
	public boolean isValid(String s) {
		if(s == null || s.length() == 0)
			return false;
        LinkedList<Character> stack = new LinkedList<Character>();
        int i = 1;
        stack.push(s.charAt(0));
        while(i<s.length()){
        	if(s.charAt(i) == '(' ||s.charAt(i) == '{'  || s.charAt(i) == '[' )
        		stack.push(s.charAt(i));
        	else{
        	    if(stack.isEmpty())
        	        return false;
        		char temp = stack.pop();
        		if(s.charAt(i) == ')' && temp != '(')
        			return false;
        		else if(s.charAt(i) == '}' && temp != '{')
        			return false;
        		else if(s.charAt(i) == ']' && temp != '[')
        			return false;
        	}
        	i++;
        }
        if(!stack.isEmpty())
            return false;
        return true;
    }
}