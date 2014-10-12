class Restore_IP_Addresses{
	public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12)
            return res;
        genValidIp(s,res,"",1);
        return res;

    }
    private void genValidIp(String s, ArrayList<String> res, String curr, int sec){
    	if(sec == 4){
    		if(validSec(s)){
    			curr = curr + s;
    			res.add(curr);
    			return;
    		}
    		return;
    	}
    	else{
    		for(int i=1;i<=3 && i<s.length();i++){
    			if(validSec(s.substring(0,i))){
    				genValidIp(s.substring(i),res,curr+s.substring(0,i)+".",sec+1);
    			}
    		}
    	}

    }
    private boolean validSec(String s){
    	if(s == null || s.length() == 0)
    		return false;
    	if(s.charAt(0) == '0' && s.length() != 1)
    		return false;
    	int i = Integer.valueOf(s);
    	if(i>=0 && i<=255)
    		return true;
    	return false;
    }
}