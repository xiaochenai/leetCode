class Reverse_Words_in_a_String{
	public String reverseWords1(String s) {
        String[] ss = s.split(" ");
        String res = "";
        for(String t:ss){
        	if(!t.equals(""))
        		res = t+ " " + res;
        }
        return res.length() == 0?"":res.substring(0,res.length()-1);
    }
public String reverseWords(String s) {
        s = s.trim();
    	StringBuilder sb = new StringBuilder();
    	StringBuilder word = new StringBuilder();
    	for(int i = s.length()-1;i>=0;i--){
    		if(s.charAt(i) == ' '){
    		    if(word.length()!= 0){
        			sb.append(word.toString());
        			sb.append(' ');
        			word = new StringBuilder();
    		    }
    		}
    		else{
    			word.insert(0,s.charAt(i));
    		}
    	}
    	if(word.length()!= 0){
			sb.append(word.toString());
			word = new StringBuilder();
    	}
    	return sb.toString();
    }
    public static void main(String[] args){
    	Reverse_Words_in_a_String s = new Reverse_Words_in_a_String();
    	String a = s.reverseWords("1");
    	System.out.println(a);
    }
}