class Count and Say{
	//do for n loop
	//use res to track internal string
	//init count = 1, ch, when ch do not equal update curr
	//when finish go through this round res
	//update res
	public String countAndSay(int n) {
		if(n==1)
			return "1";
		String res = "1";
		String curr = "";
		for(int i=1;i<=n;i++){
			int count = 1;
			int index = 1;
			char ch = res.charAt(0);
			while(index<res.length()){
				if(ch == res.charAt(index)){
					count++;
					index++;
				}
				else{
					curr = curr + count + ch;
					ch = res.charAt(index);
					count = 1;
					index++;
				}
			}
			res = curr + count + ch;
			curr = "";
		}
		return res;
	}
}