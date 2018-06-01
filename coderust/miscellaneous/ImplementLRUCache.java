package miscellaneous;

import common.LinkedListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement LRU (Least Recently Used) Cache. Discuss data structures involved.
 * <p>
 * Runtime Complexity:
 * - get: Constant, O(1)
 * - set: Constant, O(1)
 * Memory Complexity: Linear, O(n) where n is the size of cache.
 */
public class ImplementLRUCache {

    private int capacity;

    private Map<Integer, LinkedListNode> cache;
    private LinkedListNode<LinkedListNode> cacheVals;

    public ImplementLRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>(capacity);
        cacheVals = new LinkedListNode<>();
    }

    public static void main(String[] args) {

    }

    public int get(int key) {
        LinkedListNode node = cache.get(key);
        if (node == null) {
            return -1;
        } else {
            // cacheVals.remove(node);
            cacheVals.appendToTail(node);
            return (int) node.data;
        }
    }

    public void set(int key, int value) {
        LinkedListNode node = cache.get(key);
        if (node == null) {
            evictIfNeeded();
            // node = new LinkedListNode(key, value);
            cacheVals.appendToTail(node);
            cache.put(key, node);
        } else {
            node.data = value;
            // cacheVals.remove(node);
            cacheVals.appendToTail(node);
        }
    }

    public void evictIfNeeded() {
        /*if (cacheVals.size() >= capacity) {
            LinkedListNode node = cacheVals.remove();
            cache.remove(node.key);
        }*/
    }

    public void print() {
        /*ListIterator<LinkedListNode> iterator = cacheVals.listIterator(0);
        while (iterator.hasNext()) {
            LinkedListNode node = iterator.next();
            System.out.print(node.key + ":" + node.data + ", ");
        }
        System.out.println("");*/
    }
}
