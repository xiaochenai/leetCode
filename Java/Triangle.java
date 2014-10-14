class Triangle{
    public int minimumTotal(List<List<Integer>> triangle) {
    	if(triangle == null || triangle.size() == 0)
    		return 0;
    	int len = triangle.size();
        int[] max = new int[triangle.get(len-1).size()];
        for(int i=0;i<max.length;i++){
        	max[i] = triangle.get(len-1).get(i);
        }
        for(int i=len-2;i>=0;i--){
        	for(int j=0;j<triangle.get(i).size();j++){
        		max[j] = triangle.get(i).get(j) + Math.min(max[j],max[j+1]);
        	}
        }
        return max[0];

    }
}