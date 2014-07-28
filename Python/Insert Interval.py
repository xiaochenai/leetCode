# Definition for an interval.
class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

# Definition for an interval.
# class Interval:
    # def __init__(self, s=0, e=0):
        # self.start = s
        # self.end = e

class Solution:
    # @param intervals, a list of Intervals
    # @param newInterval, a Interval
    # @return a list of Interval
    def insert(self, intervals, newInterval):
		Len = len(intervals)
		i = 0
		if Len == 0:
			return [newInterval]
		intervals.append(Interval(65536,65537))
		while i < len(intervals) :
			if intervals[i].start>=newInterval.start:
				intervals.insert(i,newInterval)
				break
			i = i + 1
		stop = i
		start = i - 1 if i>1 else 0
		while start < stop + 2 and (start< len(intervals)-1):
			if intervals[start].end >= intervals[start+1].start:
				newStart = intervals[start].start
				newEnd = intervals[start].end if intervals[start].end>=intervals[start+1].end else intervals[start+1].end
				intervals.pop(start)
				intervals.pop(start)
				intervals.insert(start,Interval(newStart,newEnd))
				continue
			start = start + 1
		intervals.pop()
		return intervals
		
		
##another solution
# Definition for an interval.
# class Interval:
    # def __init__(self, s=0, e=0):
        # self.start = s
        # self.end = e

class Solution:
    # @param intervals, a list of Intervals
    # @param newInterval, a Interval
    # @return a list of Interval
    def insert(self, intervals, newInterval):
		rs = []
		i = 0
		while i<len(intervals) and intervals[i].end<newInterval.start:
			rs.append(intervals[i])
			i = i + 1
		if i == len(intervals):
			rs.append(newInterval)
			return rs
		newInterval.start = min(intervals[i].start,newInterval.start)
		while i < len(intervals) and intervals[i].start <= newInterval.end:
			newInterval.end = max(newInterval.end,intervals[i].end)
			i = i + 1
		rs.append(newInterval)
		while i < len(intervals):
			rs.append(intervals[i])
			i = i + 1
		return rs