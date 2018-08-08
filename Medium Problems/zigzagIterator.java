class ZigzagIterator {
    // Iterator<Integer> i1;
    // Iterator<Integer> i2;
    // Iterator<Integer> current;
    
    Queue<Iterator<Integer>> queue;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        // i1 = v1.iterator();
        // i2 = v2.iterator();
        // current = i1.hasNext() ? i1: i2;
        queue = new LinkedList<>();
        if(!v1.isEmpty())
            queue.offer(v1.iterator());
        if(!v2.isEmpty())
            queue.offer(v2.iterator());
    }
    
    int next() {
        Iterator<Integer> temp = queue.poll();
        int ret = temp.next();
        if(temp.hasNext())
            queue.offer(temp);
        // int ret = current.next();
        // if(current = i1) {
        //     if(i2.hasNext())
        //         current = i2;
        // } else {
        //     if(i1.hasNext())
        //         current = i1;
        // }
        return ret;
    }
    
    boolean hasNext() {
        return !queue.isEmpty();
        // return current.hasNext();
    }
}
