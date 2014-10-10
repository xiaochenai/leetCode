class Longest_Valid_Parentheses{
	public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        int i = 0;
        int max = 0;
        while(i<s.length()){
        	if(s.charAt(i) == ')'){
        		int index = stack.peek();
        		if(index != -1){
        			if(s.charAt(index) == '('){
        				stack.pop();
        				max = Math.max(max,i-stack.peek());
        			}
        			else{
        				stack.push(i);
        			}
        		}
        		//is stack is empty push ')' into stack
        		else
        			stack.push(i);
        	}
        	else
        		stack.push(i);
        	i++;
        }
        return max;
    }
}