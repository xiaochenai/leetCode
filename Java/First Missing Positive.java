public class Solution {
    public int firstMissingPositive(int[] A) {
        Arrays.sort(A);
		int i=0;
		int res=0;
		while (i<A.length() && A[i]<=0)
			i += 1;
		for(;i<A.length();i++){
			if (i > 0 && A[i] == A[i-1])
				continue;
			if (A[i] - res != 1)
				return res+1;
			else
				res += 1;
		}
		return res+1;
    }
}

public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i=0;i<A.length;i++){
			while (A[i] != i+1){
				if (A[i]<=0 || A[i] >= A.length || A[i] == A[A[i]-1])
					break;
				int temp = A[i];
				A[i] = A[temp-1];
				A[temp-1] = temp;
			}
		}
		for(int i=0;i<A.length;i++){
			if (A[i] != i+1)
				return i+1;
		}
		return A.length+1;
    }
}