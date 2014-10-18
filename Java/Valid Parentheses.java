class Valid Parentheses{
	public boolean isValid(String s) {
        int index = 0;
        LinkedList<Character> stack = new LinkedList<Character>();
        while(index<s.length()){
        	if(s.charAt(index) == '(' || s.charAt(index) == '{' || s.charAt(index) == '['){
        		stack.push(s.charAt(index));
        		index++;
        	}
        	else if(s.charAt(index) == ')'){
        		if(stack.isEmpty() || stack.peek() != '(')
        			return false;
        		else{
        			stack.pop();
        			index++;
        		}
        	}
        	else if(s.charAt(index) == ']'){
        		if(stack.isEmpty() || stack.peek() != '[')
        			return false;
        		else{
        			stack.pop();
        			index++;
        		}

        	}
        	else if(s.charAt(index) == '}'){
        		if(stack.isEmpty() || stack.peek() != '{')
        			return false;
        		else{
        			stack.pop();
        			index++;
        		}
        	}
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }
}