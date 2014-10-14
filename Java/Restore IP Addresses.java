class Restore IP Addresses{
	public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12)
            return res;
        genValidIp(s,res,"",1);
        return res;

    }
    private void genValidIp(String s,ArrayList<String> res, String curr,int sec){
    	if(sec == 4){
    		if(isValid(s)){
    			res.add(curr+s);
    		}
    		return;
    	}
    	for(int i=1;i<=3 && i<=s.length();i++){
    		if(isValid(s.substring(0,i))){
    			String temp = curr==""?s.substring(0,i)+".":curr+s.substring(0,i)+".";
    			genValidIp(s.substring(i),res,temp,sec+1);
    		}
    	}
    }
    private boolean isValid(String s){
        if(s == null || s.length() == 0)
    		return false;
    	if(s.charAt(0) == '0')
    		return (s.length() == 1);
    	int ip = Integer.parseInt(s);
    	if(ip>=0 && ip <= 255)
    		return true;
    	return false;
    }
}