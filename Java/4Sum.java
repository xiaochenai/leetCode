public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        if (num.length < 4)
			return res;
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> res = new ArrayList<List<Integer>>();
		HashSet<ArrayList<Integer>> hashSet = new HashSet<ArrayList<Integer>>();
		for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				int left = j+1;
				int right = num.length - 1;
				while (left < right){
					int sum = num[i]+num[j]+num[right]+num[left];
					if (sum > target){
						right--;
					}
					else if (sum < target){
						left++;
					}
					else if (sum == target){
						ArrayList<Integer> solution = new ArrayList<Integer>();
						solution.add(num[i]);
						solution.add(num[j]);
						solution.add(num[left]);
						solution.add(num[right]);
						if(!hashSet.contains(solution)){
							hashSet.add(solution);
							res.add(solution);
						}
						left++;
						right--;
					}
				}
			}
		}
		return res;
    }
}
//another solution using pair concept
public class Solution {
	private ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
		if (num.length < 4)
			return res;
		Arrays.sort(num);
		HashMap<Integer,ArrayList<ArrayList<Integer>>> map = new HashMap<Integer,ArrayList<ArrayList<Integer>>>();
		for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				int T = num[i] + num[j];
				if (map.containsKey(T)){
					//System.out.println("Contains Key : " + T);
					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(i);
					temp.add(j);
					map.get(T).add(temp);
				}
				else{
					ArrayList<Integer> temp = new ArrayList<Integer>();
					ArrayList<ArrayList<Integer>> outTemp = new ArrayList<ArrayList<Integer>>();
					temp.add(i);
					temp.add(j);
					outTemp.add(temp);
					map.put(T,outTemp);
				}
			}
		}
		for(int i=0;i<num.length;i++){
			for(int j=i+1;j<num.length;j++){
				int T = target - num[i] - num[j];
				if (map.containsKey(T)){
					ArrayList<ArrayList<Integer>> outTemp = map.get(T);
					for(int k=0;k<outTemp.size();k++){
						if(outTemp.get(k).get(0) > j){
							ArrayList<Integer> solution = new ArrayList<Integer>();
							solution.add(num[i]);
							solution.add(num[j]);
							solution.add(num[outTemp.get(k).get(0)]);
							solution.add(num[outTemp.get(k).get(1)]);
							if (!res.contains(solution))
								res.add(solution);
						}
					}
				}
			}
		}
		return res;
		
    }
	// public static void main(String[] args){
		// Solution s = new Solution();
		// int[] num= {0,0,0,0};
		// ArrayList<ArrayList<Integer>>  res = s.fourSum(num,0);
		// for(int i=0;i<res.size();i++){
			// for(int j=0;j<res.get(i).size();j++){
				// System.out.print(res.get(i).get(j) + " ");
			// }
			// System.out.println();
		// }
	// }
}
//discard
public class Solution {
	public List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] num, int target) {
		if (num.length <4)
			return res;
        Arrays.sort(num);
		int start = 0;
		int end = num.length - 1;
		while (start < end){
			int a = num[start];
			int b = num[end];
			int left = start + 1;
			int right = end - 1;
			int c = 0;
			int d = 0;
			while (left < right){
				c = num[left];
				d = num[right];
				if (a+b+c+d == target){
					LinkedList<Integer> solution = new LinkedList<Integer>();
					solution.add(a);
					solution.add(c);
					solution.add(d);
					solution.add(b);
					res.add(solution);
					left += 1;
					while (num[left] == num[left-1] && left < right)
						left += 1;
				}
				if (a+b+c+d < target){
					left += 1;
				}
				if (a+b+c+d > target){
					right -= 1;
				}
			}
			if (a+b+c+d <= target){
				start += 1;
				while (num[start] == num[start-1] && start < end)
					start += 1;
			}
			else{
				end -= 1;
				while(num[end] == num[end+1] && start < end)
					end -= 1;
			}
		}
		return res;
    }
}