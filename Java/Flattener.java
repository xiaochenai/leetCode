public static class Flattener {
        final List<List<Integer>> _vv;
        int _curList = 0;
        int _curOffset = 0;
        Iterator<Object> outIt;
        Iterator<Object> innerOffset;
        public Flattener(final List<List<Integer>> vv) {
            if (vv == null) {
                throw new IllegalArgumentException();
            }
            _vv = new ArrayList<List<Integer>>();
            for (int i = 0; i < vv.size(); ++i) {
                if (vv.get(i) == null || vv.get(i).size() == 0) {
                    continue;
                }
                _vv.add(vv.get(i));
            }
            outIt = _vv.iterator();
            if(outIt.hasNext)
                innerOffset = outIt.next().iterator();
        }
        //if !outIt.hasNext() && ! innerOffset.hasNext()
        boolean hasNext(){
            return !(!outIt.hasNext() && !innerOffset.hasNext());
        }
        boolean hasNext() {
            return !(_curList >= _vv.size());
        }
        int next(){
            if(innerOffset.hasNext())
                return innerOffset.next();
            else{
                if(outIt.hasNext()){
                    innerOffset = outIt.next().iterator();
                    while(!innerOffset.hasNext() && outIt.hasNext()){
                        innerOffset = outIt.next().iterator();
                    }
                    if(innerOffset.hasNext())
                        return innerOffset.next();
                    else
                        return -1;
                }
                else
                    return -1;
            }
        }
        int next () {
            if (_curList >= _vv.size()) {
                return -1; // Or throw
            }
            
            assert(_vv.get(_curList).size() > _curOffset);
            int cpCurOffset = _curOffset;
            int cpCurList = _curList;
            _curOffset ++;
            if (_curOffset >= _vv.get(_curList).size()) {
                _curList++;
                _curOffset = 0;
            }

            return _vv.get(cpCurList).get(cpCurOffset);
        }
    }
    
    static void testFlattener() {
        List<List<Integer>> vv = new ArrayList<List<Integer>>();
        vv.add(null);
        vv.add(new ArrayList<Integer>());
        Flattener f = new Flattener(vv);
        if (!f.hasNext()) {
            System.out.println("Flattener doesn't have next.");
        }
        
        vv.add(Arrays.asList(1, 2, 3));        
        vv.add(Arrays.asList(4, 5, 6));
        f = new Flattener(vv);
        while (f.hasNext()) {
            System.out.println(f.next());
        }
        
    }