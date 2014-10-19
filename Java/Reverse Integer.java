class Reverse Integer{
	public int reverse(int x) {
        if(x == 0)
            return 0;
        int negtive = 0;
        if(x < 0)
        	negtive = 1;
        x = Math.abs(x);
        StringBuilder sb = new StringBuilder();
        while(x>0){
        	int front = x%10;
        	sb.append(front);
        	x = x/10;
        }
        if(negtive == 1)
        	return -Integer.valueOf(sb.toString());
        else
        	return Integer.valueOf(sb.toString());
    }
}