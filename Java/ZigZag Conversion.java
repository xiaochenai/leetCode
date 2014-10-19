class ZigZag Conversion{
	public String convert(String s, int nRows) {
        if(nRows == 1)
        	return s;
        int direction = 1;
        StringBuilder[] sbs = new StringBuilder[nRows];
        for(int i=0;i<nRows;i++){
        	sbs[i] = new StringBuilder();
        }
        int curr = 0;
        for(int i=0;i<s.length();i++){
        	if(curr == nRows -1)
        		direction = -1;
        	else if(curr == 0)
        		direction = 1;
        	sbs[curr].append(s.charAt(i));
        	curr = curr + direction;
        }
        String res = "";
        for(StringBuilder sb:sbs){
        	res = res + sb.toString();
        }
        return res;
    }
}