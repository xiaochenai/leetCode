public class ImageRotation{
	public void rotateImage(int[][] matrix, int d){
		int n = matrix.length;
		for(int layer = 0;layer< n /2;layer++){
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;i++){
				int offset = i - first;
				int top = matrix[first][i];
				matrix[first][i] = matrix[last-offset][first];
				matrix[last-offset][first] =  matrix[last][last-offset];
				matrix[last][last-offset] = matrix[i][last];
				matrix[i][last] = top;
			}
		}
	}
	public void rotateImageByBlock90ClockWise(int[][] matrix,int d){
		int n = matrix.length;
		for(int i=0;i<n/2;i++){
			for(int j=0;j<Math.ceil(((double)n)/2.);j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];
				matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
				matrix[j][n-i-1] = temp;
			}
		}
	}
	public void rotateImageByBlock180ClockWise(int[][] matrix,int d){
		int n = matrix.length;
		for(int i=0;i<n/2;i++){
			for(int j=0;j<Math.ceil(((double)n)/2.);j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-i-1][n-j-1];
				matrix[n-i-1][n-j-1] = temp;
			}
		}
	}
	public void rotateImageByBlock270ClockWise(int[][] matrix,int d){
		//equals to 90 Counter-Clock-Wise
		int n = matrix.length;
		for(int i=0;i<n/2;i++){
			for(int j=0;j<Math.ceil(((double)n)/2.);j++){
				int temp = matrix[i][j];
				//right to top
				matrix[i][j] = matrix[j][n-i-1];
				//bottom to right
				matrix[j][n-i-1] = matrix[n-i-1][n-j-1];
				//left to bottom
				matrix[n-i-1][n-j-1] = matrx[n-j-1][i];
				matrix[n-j-1][i] = temp;
			}
		}
	}
}