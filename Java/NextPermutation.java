class NextPermutation{
    //find first descending elment from the back
    public void nextPermutation(int[] num) {
            int partitionIndex = -1;
            for(int i = num.length-1;i>0;i--){
                if (num[i] > num[i-1]){
                    partitionIndex = i - 1;
                    break;
                }
            }
            //traversal from the back
            //exchange the first element greater then partition element with partition element
            if(partitionIndex != -1){
                for(int i=num.length-1;i>=0;i--){
                    if(num[i] > num[partitionIndex]){
                        int tmp = num[i];
                        num[i] = num[partitionIndex];
                        num[partitionIndex] = tmp;
                        break;
                    }
                }
            }
            //reverse the list behind the partition element
            int i = partitionIndex + 1;
            int j = num.length - 1;
            while (i < j){
                int tmp = num[i];
                num[i] = num[j];
                num[j] = tmp;
                i++;
                j--;
            }
            for(int t:num){
                System.out.print(t + " ");
            }
        }
        public static void main(String[] args){
            NextPermutation a = new NextPermutation();
            int[] b = {1,2,4,3,5};
            a.nextPermutation(b);
        }
}