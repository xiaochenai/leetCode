class Implement strStr(){
	public String strStr(String haystack, String needle) {
    if(haystack==null || needle == null || needle.length()==0)
        return haystack;
    if(needle.length()>haystack.length())
        return null;
    for(int i=0;i<=haystack.length()-needle.length();i++)
    {
        boolean successFlag = true;
        for(int j=0;j<needle.length();j++)
        {
            if(haystack.charAt(i+j)!=needle.charAt(j))
            {
                successFlag = false;
                break;
            }
        }
        if(successFlag)
            return haystack.substring(i);
    }
    return null;
}

	public String strStr(String haystack, String needle) {
        int needleLen  = needle.length();
        int haystackLen = haystack.length();
        if (needleLen == haystackLen && needleLen == 0)
			return "";
 
		if (needleLen == 0)
			return haystack;
	 
		for (int i = 0; i < haystackLen; i++) {
			// make sure in boundary of needle
			//haystackLen + 1 == needleLen
			//haystackLen + 1 == needleLen-1
			if (haystackLen - i< needleLen)
				return null;
	 
			int k = i;
			int j = 0;
	 
			while (j < needleLen && k < haystackLen && needle.charAt(j) == haystack.charAt(k)) {
				j++;
				k++;
				if (j == needleLen)
					return haystack.substring(i);
			}
	 
		}
	 
		return null;
    }
}