class Pascal's Triangle{
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(numRows == 0)
            return res;
        ArrayList<Integer> row = new ArrayList<Integer>();
        row.add(1);
        res.add(new ArrayList<Integer>(row));
        for(int i=1;i<=numRows-1;i++){
        	row.add(0);
        	for(int j = row.size()-1;j>=1;j--){
        		row.set(j,row.get(j)+row.get(j-1));
        	}
        	res.add(new ArrayList<Integer>(row));
        }
        return res;
    }
}