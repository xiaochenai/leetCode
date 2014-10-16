class Plus One{
	public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0)
        	return digits;
        int carry = 1;
        int value = 0;
        for(int i = digits.length-1;i>=0;i--){
        	value = (digits[i]+carry)%10;
        	carry = (digits[i]+carry)/10;
        	digits[i] = value;
        }
        if(carry == 0)
        	return digits;
        else{
        	int[] a = new int[digits.length+1];
        	a[0] = 1;
        	System.arraycopy(digits,0,a,1,digits.length);
        	return a;
        }
    }
}