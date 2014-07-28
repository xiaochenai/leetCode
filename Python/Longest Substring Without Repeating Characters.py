# Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating 
# letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
#not accepted for the big data set
class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
		leng = len(s)
		temp = [-1 for i in xrange(95)]
		Max = 0
		i = 0
		start = 0
		currentLen = 0
		while i < leng:
			if temp[ord(s[i]) - 32] > 0:
				if Max < (i-start):
					Max = i-start
				i = temp[ord(s[i]) - 32]
				start = i + 1
				temp = [-1 for j in xrange(95)]
				i = i + 1
				continue
			temp[ord(s[i]) - 32] = i
			i = i + 1
		return Max
	
#accepted
class Solution:
    # @return an integer
    def lengthOfLongestSubstring(self, s):
        # Handle the special case: empty string
        if len(s) == 0:     return 0

        lastAppPos = {s[0]:0}               # Last appear position of alphabet
        longestEndingHere = [1] * len(s)    # Longest substring ending here

        for index in xrange(1, len(s)):
            lastPos = lastAppPos.get(s[index], -1)
            if longestEndingHere[index-1] < index - lastPos:
                # The substring, ending in the previous position, could be
                # extended WITHOUT chop.
                longestEndingHere[index] = longestEndingHere[index-1] + 1
            else:
                # The substring, ending in the previous position, have to
                # be chopped and THEN extended.
                longestEndingHere[index] = index - lastPos
            lastAppPos[s[index]] = index    # Update the last appear position

        return max(longestEndingHere)
				
a = "rlyauuzdrcnjkphclffrkeecbpdipufhidjcxjhrnxcxmjcxohqanxdrmgzebhnlmwpmhwdvthsfqueeexgrujigskmvrzgfwvrf"
s = Solution()
print s.lengthOfLongestSubstring(a)