class Longest_Valid_Parentheses{
	public int longestValidParentheses(String s) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        int i = 0;
        int max = 0;
        while(i<s.length()){
        	if(s.charAt(i) == ')'){
        		if(!stack.isEmpty()){
        			if(s.charAt(stack.peek()) == '('){
        				stack.pop();
        			}
        			else{
        				stack.push(i);
        			}
        		}
        	}
        }
    }
}