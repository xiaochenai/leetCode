public class Solution {
    public boolean isValid(String s) {
        Stack<Object> st = new Stack<Object>();
		int i=1;
		if (s.length()%2 != 0)
			return false;
		if (s.length()==0)
			return true;
		st.push(String.valueOf(s.charAt(0)));
		while (i<s.length()){
			if (String.valueOf(s.charAt(i)).equals("{") || String.valueOf(s.charAt(i)).equals("[") || String.valueOf(s.charAt(i)).equals("(")){
				st.push(String.valueOf(s.charAt(i)));
			}
			else{
				if (st.empty())
					return false;
				String current = (String)st.pop();
				if (String.valueOf(s.charAt(i)).equals(")") && !current.equals("(")){
					return false;
				}
				if (String.valueOf(s.charAt(i)).equals("}") && !current.equals("{")){
					return false;
				}
				if (String.valueOf(s.charAt(i)).equals("]") && !current.equals("[")){
					return false;
				}
			}
			i+=1;
		}
		if (!st.empty())
			return false;
		return true;
    }
}