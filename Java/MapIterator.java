class MapIterator{
	public static void printMap(Map mp) {
	    Iterator it = mp.entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pairs = (Map.Entry)it.next();
	        System.out.println(pairs.getKey() + " = " + pairs.getValue());
	        it.remove(); // avoids a ConcurrentModificationException
	    }
	}
	Map<String, Object> map = ...;

	for (String key : map.keySet()) {
	    // ...
	}
	for (Object value : map.values()) {
    // ...
	}

	for (Map.Entry<String, Object> entry : map.entrySet()) {
	    String key = entry.getKey();
	    Object value = entry.getValue();
	    // ...
	}

	Map map = new HashMap(); 
	Iterator iter = map.entrySet().iterator(); 
	while (iter.hasNext()) { 
	    Map.Entry entry = (Map.Entry) iter.next(); 
	    Object key = entry.getKey(); 
	    Object val = entry.getValue(); 
	} 

	
	Map map = new HashMap(); 
	Iterator iter = map.keySet().iterator(); 
	while (iter.hasNext()) { 
	    Object key = iter.next(); 
	    Object val = map.get(key); 
	} 

}