class Candy{
    public int candy(int[] ratings) {
        int[] candys = new int[ratings.length];
        Arrays.fill(candys,1);
        for(int i=1;i<ratings.length;i++){
        	if(ratings[i]>ratings[i-1])
        		candys[i] = candys[i-1]+1;
        }
        for(int i=ratings.length-1;i>0;i--){
        	if(ratings[i-1]>ratings[i] && candys[i-1]<=candys[i])
        		candys[i-1] = candys[i]+1; 
        }
        int sum = 0;
        for(int i:candys)
            sum+=i;
        return sum;
    }	
}