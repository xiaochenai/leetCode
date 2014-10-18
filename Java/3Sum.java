class 3Sum{
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(num == null  || num.length == 0)
            return res;
        Arrays.sort(num);
        int i = 0;
        while(i < num.length){
            int j = i + 1;
            int k = num.length - 1;
            if(i > 0 && num[i] == num[i-1]){
                i++;
                continue;
            }
            while(j<k){
            	int a = num[i];
            	int b = num[j];
            	int c = num[k];
            	if(a+b+c == 0){
            		ArrayList<Integer> temp = new ArrayList<Integer>();
            		temp.add(a);
            		temp.add(b);
            		temp.add(c);
            		res.add(temp);
            		while(j < k){
                        j++;
                        k--;
                        if(num[j] != b || num[k] != c)
                            break;
                    }
            	}
            	else if(a+b+c > 0){
            		while(j < k && num[k] == c){
            			k--;
            		}
            	}
            	else{
            		while(j < k && num[j] == b){
            			j++;
            		}
            	}
            }
            i++;
        }
        return res;
	}
}