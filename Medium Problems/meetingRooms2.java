public int minMeetingRooms(Interval[] intervals) {
    if(intervals == null|| intervals.length == 0)
        return 0;

    Arrays.sort(intervals, (a, b) -> a.start - b.start);
    
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    
    pq.add(intervals[0].end);
    for(int i = 1; i < intervals.length; i++) {
          if(intervals[i].start >= pq.peek())
              pq.poll();
          pq.offer(intervals[i].end);
    }
    return pq.size();
}
