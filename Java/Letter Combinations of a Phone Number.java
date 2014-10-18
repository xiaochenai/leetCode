class Letter Combinations of a Phone Number{
	public List<String> letterCombinations(String digits) {
		String[] trans = {""," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        ArrayList<String> res = new ArrayList<String>();
        combinations(digits,0,"",trans,res);
        return res;
	}
	//dfs
	private void combinations(String digits,int level, String curr, String[] trans, ArrayList<String> res){
		if(level == digits.length()){
			res.add(curr);
			return;
		}
		int num = (int)(digits.charAt(level) - '0');
		for(int i=0;i<trans[num].length();i++){
			combinations(digits,level+1,curr+tras[num].charAt(i),res);
		}
	}
}