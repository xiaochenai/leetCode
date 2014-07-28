# Write a function to find the longest common prefix string amongst an array of strings.

class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
		compare = ""
		if len(strs) == 0:
			return compare
		compare = strs[0]
		for i in range(1,len(strs)):
			prefix = ""
			k=0
			while k<compare.size and k<len(strs[i]):
				if compare[k] != strs[i][k]:
					break
				prefix.append(compare[k])
				k = k + 1
			compare = prefix + ""
		return compare
		
		
class Solution:
    # @return a string
    def longestCommonPrefix(self, strs):
		prefix = ""
		if len(strs) == 0:
			return prefix
		k = 0
		while True:
			if k == len(strs[0]):
				break
			p = strs[0][k]
			i = 1
			while i < len(strs):
				if k == len(strs[i]):
					break
				if p != strs[i][k]:
					break
				i = i + 1
			if i != len(strs):
				break
			prefix = prefix + p
			k = k + 1
		return prefix