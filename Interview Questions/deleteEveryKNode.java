public class HelloWorld{

    public List<Integer> deleteKNode(LinkedList list, int k) {
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while(list != 0) {
            count++;
            if(count % k == 0) {
                result.add(list.val);
                list.prev.next = list.next;
                if(list.next != null)
                    list.next.prev = list.prev;
            }
            list = list.next;
        }
        return result;
     }
}
