(1)p[j+1]不是'*'。情况比较简单，只要判断如果当前s的i和p的j上的字符一样（如果有p在j上的字符是'.',也是相同），并且res[i][j]==true，则res[i+1][j+1]也为true，res[i+1][j+1]=false;
(2)p[j+1]是'*'，但是p[j]!='.'。那么只要以下条件有一个满足即可对res[i+1][j+1]赋值为true：
1)res[i+1][j]为真（'*'只取前面字符一次）;
2)res[i+1][j-1]为真（'*'前面字符一次都不取，也就是忽略这两个字符）;
3)res[i][j+1] && s[i]==s[i-1] && s[i-1]==p[j-1](这种情况是相当于i从0到s.length()扫过来，如果p[j+1]对应的字符是‘*’那就意味着接下来的串就可以依次匹配下来，如果下面的字符一直重复，并且就是‘*’前面的那个字符）。
(3)p[j+1]是'*'，并且p[j]=='.'。因为".*"可以匹配任意字符串，所以在前面的res[i+1][j-1]或者res[i+1][j]中只要有i+1是true，那么剩下的res[i+1][j+1],res[i+2][j+1],...,res[s.length()][j+1]就都是true了。

class Solution:
    # @return a boolean
    def isMatch(self, s, p):
        dp=[[False for i in range(len(p)+1)] for j in range(len(s)+1)]
        dp[0][0]=True
        for i in range(1,len(p)+1):
            if p[i-1]=='*':
                if i>=2:
                    dp[0][i]=dp[0][i-2]
        for i in range(1,len(s)+1):
            for j in range(1,len(p)+1):
                if p[j-1]=='.':
                    dp[i][j]=dp[i-1][j-1]
                elif p[j-1]=='*':
                    dp[i][j]=dp[i][j-1] or dp[i][j-2] or (dp[i-1][j] and (s[i-1]==p[j-2] or p[j-2]=='.'))
                else:
                    dp[i][j]=dp[i-1][j-1] and s[i-1]==p[j-1]
        return dp[len(s)][len(p)]
		
#another in C
#include <stdio.h>


class Solution {
public:
	bool isMatch(const char *s, const char *p) {
		// Start typing your C/C++ solution below
		// DO NOT write int main() function    

		if( 0 == *p) return 0 == *s;

		if(*(p+1) != '*')
		{
			if(*p == *s || (*p) == '.' && (*s) != 0)
			{
				return isMatch(s+1, p+1);
			}
			return false;
		}
		else
		{
			while(*p == *s || ((*p) == '.' && (*s) != 0))
			{
				if(isMatch(s, p + 2))
				{
					return true;
				}
				s++;
			}
			return isMatch(s, p + 2);

		}
		
	}
};


#recursive
class Solution:
    # @return a boolean
    def isMatch(self, s, p):
        if len(p)==0: return len(s)==0
        if len(p)==1 or p[1]!='*':
            if len(s)==0 or (s[0]!=p[0] and p[0]!='.'):
                return False
            return self.isMatch(s[1:],p[1:])
        else:
            i=-1; length=len(s)
            while i<length and (i<0 or p[0]=='.' or p[0]==s[i]):
                if self.isMatch(s[i+1:],p[2:]): return True
                i+=1
            return False