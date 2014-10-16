class Add Binary{
	public String addBinary(String a, String b) {
        int carry = 0;
        int value = 0;
        StringBuilder sb = new StringBuilder();
        if(a.length() < b.length()){
        	a = new String(new char[b.length()-a.length()]).replace('\0','0') + a;
        }
        else if(a.length() > b.length()){
        	b = new String(new char[a.length()-b.length()]).replace('\0','0') + b;
        }
        for(int i=b.length()-1;i>=0;i--){
        	value = (carry + (a.charAt(i)-'0') + (b.charAt(i)-'0'))%2;
        	carry = (carry + (a.charAt(i)-'0') + (b.charAt(i)-'0'))/2;
        	sb.insert(0,value);
        }
        if(carry == 1)
        	sb.insert(0,1);
        return sb.toString();
    }
}