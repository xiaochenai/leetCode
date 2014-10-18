class Longest Valid Parentheses{
	public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0)
        	return 0;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        int index = 0;
        int max = 0;
        while(index<s.length()){
        	if(s.charAt(index) == '('){
        		stack.push(index);
        		index++;
        	}
        	else{
        		if(stack.peek() != -1){
        			if(s.charAt(stack.peek()) == '('){
        				stack.pop();
        				max = Math.max(max,index - stack.peek());
        				index++;
        			}
        			else{
        				stack.push(index++);
        			}
        		}
        		else{
        			stack.push(index);
        		}
        	}
        }
        return max;
    }
}