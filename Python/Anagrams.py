class Solution:
    # @param strs, a list of strings
    # @return a list of strings
    def anagrams(self, strs):
        dict = {}
        for word in strs:
            sortedWord = ''.join(sorted(word))
            dict[sortedWord] = [word] if sortedWord not in dict else dict[sortedWord] + [word]
        res = []
        for item in dict:
            if len(dict[item]) >= 2:
                res += dict[item]
        return res