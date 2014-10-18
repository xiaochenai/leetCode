class Divide Two Integers{
	//dividend/divisor
	public int divide(int dividend, int divisor) {
		int sign = -1;
		int res = 0;
		//corner case
		if((dividend > 0 && divisor > 0) || (divisor <0 && dividend < 0))
			sign = 1;
		if(divisor == 0)
			return Integer.MAX_VALUE;
		if(dividend == Integer.MIN_VALUE){
			res = 1;
			dividend += Math.abs(divisor);
		}
		if(divisor == Integer.MIN_VALUE)
			return res;
		//divident - divisor*1 *2 *4 * 8....
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while(dividend >= divisor){
        	int temp = divisor;
        	int k = 0;
        	while(dividend >= temp && temp >=0){
        		res += 1<<k;
        		dividend -= temp;
        		k++;
        		temp = temp<<1;
        	}
        }
        if(sign == 1)
        	return res;
        return -res;
    }
}