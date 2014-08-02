public class Solution {
    public int candy(int[] ratings) {
        int[] candy = new int[ratings.length];
		for(int i=0;i<candy.length;i++)
			candy[i] = 1;
		for(int i=0;i<candy.length-1;i++){
			if (ratings[i+1] > ratings[i] && candy[i+1] <= candy[i])
				candy[i+1] = candy[i] + 1;
		}
		for(int i=candy.length-1;i>0;i--){
			if (ratings[i-1] > ratings[i] && candy[i-1] <= candy[i])
				candy[i-1] = candy[i] + 1;
		}
		int Sum = 0;
		for(int i:candy)
			Sum += i;
		return Sum;
    }
}