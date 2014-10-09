import java.util.*;
public class SimplifyPath{
	public String simplifyPath(String path) {
        String[] paths = path.split("/");
        LinkedList<String> stack = new LinkedList<String>();
        for(String s:paths){
        	if(s.equals(".") || s.equals("")){
        		continue;
        	}
        	else if(s.equals("..")){
        		if(!stack.isEmpty())
        			stack.pop();
        	}
        	else{
        		stack.push(s);
        	}
        }
        if(stack.isEmpty())
        	stack.add("");
        String res = "";
        while(!stack.isEmpty()){
        	res = "/" + stack.pop() + res;
        }
        return res;
    }
    public static void main(String[] args){
    	String test = "/..";
    	SimplifyPath s = new SimplifyPath();
    	String res = s.simplifyPath(test);
    	System.out.println(res);
    }
}