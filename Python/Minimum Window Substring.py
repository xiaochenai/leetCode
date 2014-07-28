class Solution:
    # @return a string
    def minWindow(self, S, T):
		count1 = {};count2={}
		for char in T:
			if char not in count1: count1[char]=1
			else: count1[char]+=1
		for char in T:
			if char not in count2: count2[char]=1
			else: count2[char]+=1
		start = 0
		count = len(T)
		minSize = 100000
		minStart = 0
		for end in range(len(S)):
			if S[end] in count2 and count2[S[end]]>0:#在第一次找到substring的时候，这个substring包含所有在T里的字母，，那么count1[i]<=0,在下一次遇到任何一个字母时count==0的条件会自动满足，
														#无需进入count1[S[end]]>=0的判断
				count1[S[end]] = count1[S[end]] - 1
				if count1[S[end]]>=0:#count1 记录在currentWindow里多余的字母的个数= abs(count1[i])
					count = count - 1
				if count == 0:
					while True:
						if S[start] in count2 and count2[S[start]]>0:
							if count1[S[start]] < 0:
								count1[S[start]] = count1[S[start]]+1
							else:
								break
						start = start + 1
					if minSize>end-start+1:
						minSize = end - start + 1
						minStart = start
		if minSize == 100000:return ""
		else: return S[minStart:minStart+minSize]
class Solution:
    # @return a string
    def minWindow(self, S, T):
        count1={}; count2={}
        for char in T:
            if char not in count1: count1[char]=1
            else: count1[char]+=1
        for char in T:
            if char not in count2: count2[char]=1
            else: count2[char]+=1
        count=len(T)
        start=0; minSize=100000; minStart=0
        for end in range(len(S)):
            if S[end] in count2 and count2[S[end]]>0:
                count1[S[end]]-=1
                if count1[S[end]]>=0:
                    count-=1
            if count==0:
                while True:
                    if S[start] in count2 and count2[S[start]]>0:
                        if count1[S[start]]<0:
                            count1[S[start]]+=1
                        else:
                            break
                    start+=1
                if minSize>end-start+1:
                    minSize=end-start+1; minStart=start
        if minSize==100000: return ''
        else:
            return S[minStart:minStart+minSize]