//have this problem in C3 Energy OA
class maxDiffinArray{
	public maxDiff(int[] array){
		int min = Integer.MAX_VALUE;
		int index = 0;
		int maxDiff = Integer.MIN_VALUE;
		while(index < array.length){
			int diff = array[index] - min;
			if (array[index]<min)
				min = array[index];
			maxDiff = Math.max(maxDiff,diff);
			index++;
		}
		return maxDiff;
	}
}