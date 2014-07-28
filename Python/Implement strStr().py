# implement strStr().

# Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.


class Solution:
    # @param haystack, a string
    # @param needle, a string
    # @return a string or None
    def strStr(self, haystack, needle):
		if len(haystack) < len(needle):
			return False
		i=0
		while i < (len(haystack)-len(needle)+1):
			j=0
			k=i
			while j < len(needle):
				if haystack[k] == needle[j]:
					k = k + 1
					j = j + 1
				else:
					break
			if j == len(needle):
				break
			else:
				i = i + 1
		if i == len(haystack)-len(needle)+1:
			return None
		else:
			return haystack[i:]
			
			
