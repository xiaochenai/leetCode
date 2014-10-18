class 4Sum{
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
}