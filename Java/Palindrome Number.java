class Palindrome Number{
	public boolean isPalindrome(int x) {
         if (x < 0)
			return false;
         int scale = 1;
         while(x/scale >= 10){
             scale = scale*10;
         }
		 while(x!=0){
	         int left = x/scale;
	         int right = x%10;
	         if(left != right)
	         	return false;
	         x = (x%scale)/10;
	         scale = scale/100;
	     }
	     return true;
    }
}