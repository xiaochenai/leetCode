public class Solution {
	private List<String> res = new LinkedList<String>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length()<4 || s.length()>12){
			return res;
		}
		dfs("",1,s);
		return res;
    }
	private void dfs(String temp, int round, String s){
		if (round == 4){
			if (isValidIP(s)){
				temp = temp+s;
				res.add(temp);
				return;
			}
		}
		for(int i=1;i<4 && i<s.length();i++){
			if (isValidIP(s.substring(0,i))){
				dfs(temp+s.substring(0,i)+".",round+1,s.substring(i));
			}
		}
		
	}
	private boolean isValidIP(String s){
		if (s.charAt(0) == '0')
			return (s.equals("0"));
		if (Integer.valueOf(s)>=0 && Integer.valueOf(s)<=255)
			return true;
		else
			return false;
	}
}