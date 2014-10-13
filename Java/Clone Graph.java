class Clone Graph{
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
        	return null;
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = 
        									new HashMap<UndirectedGraphNode,UndirectedGraphNode>();

        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
        queue.offer(node);
        map.put(node,newHead);
        while(!queue.isEmpty()){
        	UndirectedGraphNode curr = queue.poll();
        	ArrayList<UndirectedGraphNode> currNeighbors = (ArrayList<UndirectedGraphNode>)curr.neighbors;
        	for(UndirectedGraphNode aNeighbor:currNeighbors){
        		if(!map.containsKey(aNeighbor)){
        			UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
        			map.put(aNeighbor,copy);
        			map.get(curr).neighbors.add(copy);
        			queue.offer(aNeighbor);
        		}
        		else
        			map.get(curr).neighbors.add((map.get(aNeighbor)));
        	}
        }
        return newHead;
    }
} 