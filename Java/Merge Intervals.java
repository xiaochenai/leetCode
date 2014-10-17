class Merge Intervals{
	public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0 || intervals.size() == 1)
        	return intervals;
        Collections.sort(intervals,new startComparator());
        int index = 0;
        while(index < intervals.size()-1){
        	if(intervals.get(index).end >= intervals.get(index+1).start){
        		intervals.get(index).end = Math.max(intervals.get(index).end,intervals.get(index+1).end);
        		intervals.remove(index+1);
        		continue;
        	}
        	index++;
        }
        return intervals;
    }
}
class startComparator implements Comparator<Interval>{
	public int compare(Interval i1, Interval i2){
		return i1.start-i2.start;
	}
}