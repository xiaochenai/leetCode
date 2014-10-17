class Wildcard Matching{
	public boolean isMatch(String s, String p) {
		int i = 0;//track s
		int j = 0;//track p
		int start = -1;//track the index of previous *
		int mark = -1;// track the index of c in p matched for *
		while(i<s.length()){
			if(j<p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')){
				i++;
				j++;
			}
			else if(j<p.length() && p.charAt(j) == '*'){
				start = j++;
				mark = i;
			}
			else if(start != -1){
				j = start + 1;
				i = ++mark;
			}
			else
				return false;
		}
		while(j<p.length() && p.charAt(j) == '*')
			j++;
		return (j==p.length());
	}
}