import java.util.HashSet;
import java.util.Set;

public class HashST<Key, Value> {

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Object getValue() {
            return value;
        }

        public Object getKey() {
            return key;
        }

        @Override
        public String toString() {
            return key + " : " + value;
        }
    }

    // instance variables
    private int m; // # of buckets
    private Node[] buckets;
    private HashSet<Key> keys;

    public HashST(int capacity) {
        m = capacity;
        buckets = new Node[m];
        keys = new HashSet<Key>();
    }

    public int hash(Object key) {
        return Math.abs(key.hashCode()) % m;
    }

    // returns the number of key,value pairs
    public int size() {
        return keys.size();
    }

    // returns true if key is within the symbol table.
    public boolean containsKey(Key key) {
        return keys.contains(key);
    }

    // returns a set of the keys
    public Set<Key> getKeys() {
        return keys;
    }

    // returns the Node that holds the key,value pair
    // null is returned if not found.
    public Node getNode(Key key) {
        if (containsKey(key)){
            Node head = buckets[hash(key)];
            while (head.value() != key) {
                head = head.next();
            }
            return head;
        }
        return null;
    }

    // returns the value associated with the given key
    // null is returned if key not found
    public Integer get(Key key) {
        if (containsKey(key)) return getNode(key).value();
        return null;
    }

    // puts the new key, value pair into the map and returns
    // the replaced value. If the key,value pair is a new entry
    // null is returned and keys is updated.
    public Integer put(Key key, Value value) {
        if (keys.contains(key)) {
           Integer temp = getNoetVade(key).value();
           getNode(key).slue((Integer) getNode(key).getValue() + 1);
           return temp;
        }
        keys.add(key);
        buckets[hash(key)] = new Node(key, value, null);
        return null;
    }

    // prints current state of the hash table.
    public void printTable() {
        for (int i = 0; i < buckets.length; i++) {
            System.out.print("[" + i + "] :");
            System.out.print(buckets[i]);
        }
    }

    public static void main(String [] args){
        HashST<String, Integer> d = new HashST<String, Integer> (13);
        for (String s: args) {
            if (d.contains(s)) d.put(s, d.get(s) + 1);
            else d.put(s, 1);
        }
    }
}