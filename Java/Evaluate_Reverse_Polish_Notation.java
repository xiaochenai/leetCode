class Evaluate_Reverse_Polish_Notation{
	public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0)
        	return 0;
        LinkedList<String> stack = new LinkedList<String>();
        for(String s:tokens){
        	if(s.equals("+")){
        		int op1 = Integer.valueOf(stack.pop());
        		int op2 = Integer.valueOf(stack.pop());
        		stack.push((op1+op2)+"");
        	}
        	else if(s.equals("-")){
        		int op1 = Integer.valueOf(stack.pop());
        		int op2 = Integer.valueOf(stack.pop());
        		stack.push((op2-op1)+"");
        	}
        	else if(s.equals("*")){
        		int op1 = Integer.valueOf(stack.pop());
        		int op2 = Integer.valueOf(stack.pop());
        		stack.push((op1*op2)+"");
        	}
        	else if(s.equals("/")){
        		int op1 = Integer.valueOf(stack.pop());
        		int op2 = Integer.valueOf(stack.pop());
        		stack.push((op2/op1)+"");
        	}
        	else{
        		stack.push(s);
        	}
        }
        return Integer.valueOf(stack.pop());
    }
}