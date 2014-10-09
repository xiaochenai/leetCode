import java.util.*;
public class minMaxheap{
	public static void main(String[] args){
		System.out.println("max Heap");
		PriorityQueue<Integer> res = new PriorityQueue(5,new maxComparator());
		System.out.println("add 1 and 2");
		res.offer(1);
		res.offer(2);
		for(Integer i:res)
			System.out.println(i);
		System.out.println("add 3");
		res.offer(3);
		for(Integer i:res)
			System.out.println(i);
		System.out.println("poll out the top of heap");
		res.poll();
		for(Integer i:res)
			System.out.println(i);
		System.out.println("min Heap");
		res = new PriorityQueue(5,new minComparator());
		System.out.println("add 1 and 2");
		res.offer(1);
		res.offer(2);
		for(Integer i:res)
			System.out.println(i);
		System.out.println("add 3");
		res.offer(3);
		for(Integer i:res)
			System.out.println(i);
		System.out.println("poll out the top of heap");
		res.poll();
		for(Integer i:res)
			System.out.println(i);
		
	}
}
class minComparator implements Comparator<Integer>{
	public int compare(Integer x, Integer y){
		return x-y;
	}
}
class maxComparator implements Comparator<Integer>{
	public int compare(Integer x,Integer y){
		return y-x;
	}
}
