class Solution:
    # @param ratings, a list of integer
    # @return an integer
    def candy(self, ratings):
		Len = len(ratings)
		candy = [1 for i in xrange(Len)]
		for i in xrange(Len-1):
			if ratings[i+1] > ratings[i] and candy[i+1] <= candy[i]:
				candy[i+1] = candy[i]+1
		for i in reversed(xrange(1,Len)):
			if ratings[i-1]>ratings[i] and candy[i-1]<=candy[i]:
				candy[i-1] =candy[i] +1
		return sum(candy)
		
d[i] 是给第i个小孩最少几块糖
rank[i] > rank[i - 1]，必须比前一个多给一块，d[i] = d[i - 1] + 1
rank[i] == rank[i - 1]，两个排名一样，第二个就给一块就行了, d[i] = 1
rank[i] < rank[i - 1]，比上一个排名低，应该少给一块，但是若上一个已经只给一块了，
就得往前推一个一个多给。推到什么时候为止呢？若排名比下一个高，糖还一样多，就得再给；直到这个关系打破（排名一样或比下一个还低，或是糖已经满足关系）就不用再往前推了。