class Gray Code{
	public List<Integer> grayCode(int n) {
        return mathSolution(n);
    }
    private ArrayList<Integer> mathSolution(int n){
        ArrayList<Integer> res = new ArrayList<Integer>();
        int size = 1<<n;
        for(int i=0;i<size;i++){
            res.add(i ^ (i>>1));
        }
        return res;
    }
    private ArrayList<Integer> recursiveSolution(int n){
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(n == 0){
            res.add(0);
            return res;
        }
        ArrayList<Integer> preRes = recursiveSolution(n-1);
        res.addAll(preRes);
        for(int i=0;i<preRes.size();i++){
            res.add(preRes.get(preRes.size()-i-1) + (int)(1<<(n-1)));
        }
        return res;
    }
    private ArrayList<Integer> iterativeSolution(int n){
        ArrayList<Integer> res = new ArrayList<Integer>();
        res.add(0);
        for(int i=0;i<n;i++){
            int currLen = res.size();
            int highestBit = 1<<i;
            for(int j=currLen-1;j>=0;j--){
                res.add(res.get(j) + highestBit);
            }
        }
        return res;
    }
    
}