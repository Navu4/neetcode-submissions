class LRUCache {
    class ListNode {
        int val, key;
        ListNode next, prev;
    
        ListNode(int key, int val){
            this.val = val;
            this.key = key;
        }
        
        ListNode(int key, int val, ListNode prev, ListNode next){
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
    
    private int capacity = -1;
    private ListNode head = null, tail = null;
    private HashMap<Integer, ListNode> map = new HashMap<>();
    
    private void updateDoublyLinkedList(ListNode node) {
        if(node == null)
            return;
        
        ListNode prev = node.prev, forw = node.next;
        
        prev.next = forw;
        forw.prev = prev;
        
        addFirst(node);
    }
    
    private void addFirst(ListNode node) {
        if(node == null)
            return;
        
        ListNode temp = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        
        node.next = temp;
        temp.prev = node;
    }
    
    private void addValToList(ListNode node) {
        if(node == null)
            return;
        
        addFirst(node);
        if(map.size() > this.capacity){
            ListNode rNode = this.tail.prev;
            
            ListNode prev = rNode.prev;
            prev.next = this.tail;
            this.tail.prev = prev;
            
            rNode.prev = rNode.next = null;
            map.remove(rNode.key);
        } 
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            updateDoublyLinkedList(node);
            
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            
            updateDoublyLinkedList(node);
        } else {
            ListNode node = new ListNode(key, value);
            map.put(key, node);
            
            addValToList(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */