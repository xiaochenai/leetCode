class Container With Most Water{
	public int maxArea(int[] height) {
        int minHeight = 0;
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while(left < right){
        	int curr = Math.min(height[left],height[right])*(right-left);
        	max = Math.max(max,curr);
        	int currL = left;
        	int currR = right;
        	if(height[left]<height[right]){
        		left++;
        		while(left<right && height[left]<=height[currL])
        			left++;
        	}
        	else{
        		right--;
        		while(left < right && height[right]<=height[currR])
        			right--;
        	}
        }
        return max;
    }
}