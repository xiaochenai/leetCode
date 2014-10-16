class Simplify Path{
	public String simplifyPath(String path) {
        LinkedList<String> stack = new LinkedList<String>();
        String[] paths = path.split("/");
        for(String s:paths){
        	if(s.equals("..")){
        		if(!stack.isEmpty())
        			stack.pop();
        	}
        	else if(s.equals(".")|| s.equals(""))
        		continue;
        	else
        		stack.push(s);
        }
        String res = "";
        if(stack.isEmpty())
        	return "/";
        while(!stack.isEmpty()){
        	res = "/" + stack.pop() + res;
        }
        return res;
    }
}