class Length of Last Word{
	public int lengthOfLastWord(String s) {
        String[] ss = s.split(" ");
        for(int i=ss.length-1;i>=0;i--){
        	if(!ss[i].equals("")){
        		return ss[i].length();
        	}
        }
        return 0;
    }
}