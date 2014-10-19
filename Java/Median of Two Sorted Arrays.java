class Median of Two Sorted Arrays{
	public double findMedianSortedArrays(int A[], int B[]) {
        int lenOfA = A.length;
        int lenOfB = B.length;
        int totalLen = lenOfA + lenOfB;
        if(totalLen%2 == 1)
            return kthNumber(A, B, totalLen/2+1);
        else
            return 0.5*(kthNumber(A, B, totalLen/2+1) + kthNumber(A, B, totalLen/2));

    }
    private double kthNumber(int A[], int B[], int k){
        if (A.length > B.length)
            return kthNumber(B,A,k);
        if (A.length == 0)
            return B[k-1];
        if (k == 1)
            return Math.min(A[0],B[0]);
        int pa = Math.min(k/2,A.length);
        int pb = k - pa;
        return A[pa-1] > B[pb-1]?kthNumber(A,Arrays.copyOfRange(B,pb,B.length),k-pb):kthNumber(Arrays.copyOfRange(A,pa,A.length),B,k-pa); 
        
    }
}