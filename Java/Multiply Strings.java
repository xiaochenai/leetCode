class Multiply Strings{
	public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
            return "";
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] temp = new int[num1.length()+num2.length()];
        for(int i=0;i<num1.length();i++){
        	for(int j=0;j<num2.length;j++){
        		temp[i+j] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
        	}
        }
        int carry = 0;
        int value = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<temp.length;i++){
        	value = (carry+temp[i])%10;
        	carry = (carry+temp[i])/10;
        	sb.insert(0,value);
        }
        while(sb.length() > 0 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }
} 