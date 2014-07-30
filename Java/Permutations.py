public class Solution {
	public List<List<Integer>> res = new LinkedList<List<Integer>>();
    public List<List<Integer>> permute(int[] num) {
		if (num.length == 0)
			return res;
        int[] visited = new int[num.length];
		for(int i=0;i<num.length;i++){
			visited[i]=0;
		}
		LinkedList<Integer> solution = new LinkedList<Integer>();
		findPermute(0,visited,solution,num);
		return res;
    }
	private void findPermute(int round, int[] visited,LinkedList<Integer> solution,int[] num){
		if (round == num.length){
			res.add(new LinkedList<Integer>(solution));
			return;
		}
		for(int i=0;i<num.length;i++){
			if (visited[i] == 0){
				visited[i] = 1;
				solution.add(num[i]);
				findPermute(round+1,visited,solution,num);
				solution.removeLast();
				visited[i]=0;
			}
			
		}
	}
}