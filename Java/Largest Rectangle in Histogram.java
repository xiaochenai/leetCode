class Largest Rectangle in Histogram{
	//similar to brute force, for every eligible col calc the maxAre form with left side col
	//if right col higher then curr col the acra must be larger that form by curr col
	public int largestRectangleArea(int[] height) {
		int maxV = 0;
        for(int i=0;i<height.length;i++){
        	if(i<height.length-1 && height[i] <= height[i+1])
                continue;
            int minH = height[i];
            for(int j=i;j>=0;j--){
            	minH = Math.min(minH,height[i]);
            	maxV = Math.max(maxV,minH*(i-j+1));
            }
        }
        return maxV;
    }
    //use a stack to maintain the index of height, when curr col's height less then
    public int largestRectangleArea(int[] height) {
    	int maxV = 0;
    	LinkedList<Integer> stack = new LinkedList<Integer>();
    	int i=0;
    	int[] h = new int[height.length + 1];
        h = Arrays.copyOf(height, height.length + 1);
    	while(i < h.length){
    		if(stack.isEmpty() || h[i] >= h[stack.peek()]){
    			stack.push(i);
    			i++;
    		}
    		else{
    			int minH = h[stack.pop()];
    			if(stack.isEmpty()){
    				maxV = Math.max(maxV,minH*(i));
    			}
    			else{
    				maxV = Math.max(maxV,minH*(i-stack.peek()-1));
    			}

    		}
    	}
    	return maxV;
    }
}