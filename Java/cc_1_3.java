class cc_1_3{
	public void solution(char[] str){
		if (str == null) return;
		if (str.length < 2) return;
		int len = 1;
		boolean[] hit = new boolean[256];
		hit[str[0]] = true;
		int tail = 1;
		for(int i = 1;i<str.length;i++){
			if(!hit[str[i]]){
				str[tail] = str[i];
				hit[str[i]] = true;
				tail++;
			}
		}
		str[tail] = 0;
		for(char c:str)
			System.out.print(c + " ");

	}
	//in-place version
	public void solution2(char[] str){
		if (str == null) return;
		if (str.length < 2) return;
		int len = 1;
		int tail = 1;
		for(int i=1;i<str.length;i++){
			int j=0;
			for(j=0;j<tail;j++){
				if(str[j] == str[i])
					break;
			}
			if(j == tail){
				str[tail] = str[i];
				tail++;
			}
		}
		str[tail] = 0;
		for(char c:str)
			System.out.print(c+" ");
	}
	public static void main(String[] args){
		char[] c = {'a','a','b','c','c'};
		cc_1_3 c1 = new cc_1_3();
		c1.solution(c);
		c1.solution2(c);
	}
}