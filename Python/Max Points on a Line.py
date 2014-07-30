# Definition for a point
# class Point:
#     def __init__(self, a=0, b=0):
#         self.x = a
#         self.y = b

class Solution:
    # @param points, a list of Points
    # @return an integer
    def maxPoints(self, points):
		length = len(points)
		if length < 3:return length
		res= -1
		for i in xrange(length):
			slope = {"inf":0}
			samePoints = 1
			for j in xrange(i+1,length):
				if i==j:
					continue
				if points[i].x == points[j].x and points[i].y!=points[j].y:
					slope["inf"]+=1
				elif points[i].x != points[j].x:
					k = 1.0*(points[j].y-points[i].y)/(points[j].x-points[i].x)
					slope[k] = 1 if k not in slope else slope[k]+1
				else:
					samePoints+=1
			res = max(res,max(slope.values())+samePoints)
		return res