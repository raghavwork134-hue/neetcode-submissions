class LFUCache {

    class Node {
        int key, value, freq;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DoublyLinkedList {
        Node head, tail;
        int size;

        DoublyLinkedList() {
            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;

            size = 0;
        }

        void add(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;

            size++;
        }

        void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;

            size--;
        }

        Node removeLast() {

            if (size == 0)
                return null;

            Node node = tail.prev;

            remove(node);

            return node;
        }
    }

    private int capacity;
    private int minFreq;

    private HashMap<Integer, Node> cache;
    private HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity) {

        this.capacity = capacity;

        cache = new HashMap<>();
        freqMap = new HashMap<>();

        minFreq = 0;
    }

    public int get(int key) {

        if (!cache.containsKey(key))
            return -1;

        Node node = cache.get(key);

        update(node);

        return node.value;
    }

    public void put(int key, int value) {

        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {

            Node node = cache.get(key);

            node.value = value;

            update(node);

            return;
        }

        if (cache.size() == capacity) {

            DoublyLinkedList list = freqMap.get(minFreq);

            Node remove = list.removeLast();

            cache.remove(remove.key);
        }

        Node node = new Node(key, value);

        cache.put(key, node);

        minFreq = 1;

        freqMap.putIfAbsent(1, new DoublyLinkedList());

        freqMap.get(1).add(node);
    }

    private void update(Node node) {

        int freq = node.freq;

        DoublyLinkedList list = freqMap.get(freq);

        list.remove(node);

        if (freq == minFreq && list.size == 0)
            minFreq++;

        node.freq++;

        freqMap.putIfAbsent(node.freq, new DoublyLinkedList());

        freqMap.get(node.freq).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */