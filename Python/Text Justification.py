class Solution:
    # @param words, a list of strings
    # @param L, an integer
    # @return a list of strings
    def fullJustify(self, words, L):
		res = []
		i = 0
		while i<len(words):
			size=0
			begin=i
			while i < len(words):
				newsize = len(words[i]) if size==0 else size+len(words[i])+1#count in at least one space between words
				if newsize<=L:size = newsize
				else:break
				i = i + 1
			spaceCount = L-size
			if i-begin-1>0 and i<len(words): #i-begin-1 is 0 or bigger than 0: means how many words in this line. not last line and more than one word
				everyCount = spaceCount/(i-begin-1)
				spaceCount = spaceCount%(i-begin-1)
			else:
				everyCount=0
			j=begin
			while j<i:
				if j==begin:s=words[j]
				else:
					s = s + " "*(everyCount+1)
					if spaceCount>0 and i<len(words):
						s = s + " "
						spaceCount = spaceCount - 1
					s = s + words[j]
				j = j + 1
			s = s + " "*spaceCount
			res.append(s)
		return res