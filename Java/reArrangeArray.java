public class reArrangeArray{
	//when re-arrange the array should be care not to break previous subarray
	public int[] reArrange(int[] a){
		if(a.length == 1)
			return a;
		if(a.length == 2){
			if(a[0] < a[1]){
				int temp = a[0];
				a[0] = a[1];
				a[1] = temp;
			}
			return a;
		}
		for(int i=2;i<a.length;i++){
			if(a[i-1]>=a[i] && a[i-1]>=a[i-2])//MBL or LBM
				continue;
			else if(a[i-2]>=a[i-1] && a[i-1]<=a[i])//MLB or BLM
				continue;
			else if(a[i-2]<=a[i-1] && a[i-1]<= a[i]){//LMB--->LBM
				int temp = a[i-1];
				a[i-1] = a[i];
				a[i] = temp;
			}
			//BML
			else if(a[i-2]>=a[i-1] && a[i-1]>=a[i]){
				int temp = a[i-2];
				a[i-2] = a[i-1];
				a[i-1] = temp;
			}
		}
		return a;
	}
	public static void main(String[] args){
		int[] a = {1,2,3,4,5,6,7,8};
		reArrangeArray s = new reArrangeArray();
		int[] b = s.reArrange(a);
		for(int i:b)
			System.out.print(i + " ");
	}
}