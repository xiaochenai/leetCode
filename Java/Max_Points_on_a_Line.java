import java.util.*;
public class Max_Points_on_a_Line{
	//notice the negative zero of doule
    public int maxPoints(Point[] points) {
        if(points == null || points.length == 0)
        	return 0;
        int res = 0;
        for(int i = 0;i<points.length;i++){
        	HashMap<String,Integer> map = new HashMap<String,Integer>();
        	int same = 1;
        	map.put("infi",0);
        	int max = 0;
        	for(int j=i+1;j<points.length;j++){
        		if(points[i].x == points[j].x && points[i].y != points[j].y){
        			map.put("infi",map.get("infi")+1);
        			max = Math.max(max,map.get("infi"));
        		}
        		else if(points[i].x != points[j].x ){
        			double slop = 0.0 + (double)(points[i].y-points[j].y)/(double)(points[i].x-points[j].x);
        			String key = String.valueOf(slop);
        			if(map.containsKey(key))
        				map.put(key,map.get(key)+1);
        			else
        				map.put(key,1);
        			//System.out.println(key + " " + map.get(key) + " " + i);
        			max = Math.max(max,map.get(key));
        		}
        		else{
        			same++;
        		}
        	}
        	res = Math.max(res,max+same);
        }
        return res;
    }	
    public static void main(String[] args){
    	Max_Points_on_a_Line s = new Max_Points_on_a_Line();
    	Point[]  p = new Point[3];
    	p[0] = new Point(2,3);
    	p[1] = new Point(3,3);
    	p[2] = new Point(-5,3);
    	int i = s.maxPoints(p);
    	System.out.println(i);
    }
} 


class Point {
      int x;
      int y;
     Point() { x = 0; y = 0; }
     Point(int a, int b) { x = a; y = b; }
  }
 