class Insert Interval{
	public List<Interval> insert(List<Interval> intervals, Interval newInterval){
		int index = 0;
		while(index < intervals.size() && newInterval.start > intervals.get(index).end){
			index++;
		}
		if(index == intervals.size()){
			intervals.add(newInterval);
			return intervals;
		}
		if(newInterval.end < intervals.get(index).start){
			intervals.add(index,newInterval);
			return intervals;
		}
		newInterval.start = Math.min(newInterval.start,intervals.get(index).start);
		while(index < intervals.size() && newInterval.end >= intervals.get(index).start){
			newInterval.end = Math.max(newInterval.end,intervals.get(index).end);
			intervals.remove(index);
		}
		intervals.add(index,newInterval);
		return intervals;
	}
}