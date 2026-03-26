import java.util.LinkedList;

class MyHashSet {

    private static final int SIZE = 1000; // number of buckets
    private LinkedList<Integer>[] buckets;

    // Constructor
    public MyHashSet() {
        buckets = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function
    private int hash(int key) {
        return key % SIZE;
    }

    // Add key
    public void add(int key) {
        int index = hash(key);
        if (!buckets[index].contains(key)) {
            buckets[index].add(key);
        }
    }

    // Remove key
    public void remove(int key) {
        int index = hash(key);
        buckets[index].remove((Integer) key);
    }

    // Check if key exists
    public boolean contains(int key) {
        int index = hash(key);
        return buckets[index].contains(key);
    }
}