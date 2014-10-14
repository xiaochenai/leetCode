class Pascal's Triangle II{
	public ArrayList<Integer> getRow(int rowIndex) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		res.add(1);
		for(int i=1;i<=rowIndex;i++){
			res.add(0);
			for(int j=res.size()-1;j>=1;j--){
				res.set(j,res.get(j)+res.get(j-1));
			}
		}
		return res;
	}
}