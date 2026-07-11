/*
146. LRU Cache (Self-Documenting Architecture - DAY 106!)

This solution optimally designs an LRU Cache with O(1) time complexity for 
both GET and PUT operations by hybridizing a HashMap with a Doubly Linked List.

Senior Twist: Enterprise Nomenclature & Self-Documenting Code.
Generic linked list terms (`head`, `tail`, `insert`) do not describe a Cache Policy. 
By applying architectural names like `mruAnchor` (Most Recently Used) and `lruAnchor`, 
alongside highly specific methods like `markAsMostRecentlyUsed`, the state transitions 
of the eviction policy are explicitly documented in the code itself!
*/
import java.util.HashMap;

class LRUCache {

    // Internal Doubly Linked List Node
    class CacheNode {
        int key;
        int value;
        CacheNode prev;
        CacheNode next;

        CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int maxCapacity;
    private HashMap<Integer, CacheNode> keyToNodeMap;
    
    // Sentinel anchors to prevent null-pointer edge cases during structural updates
    private CacheNode mruAnchor; // Most Recently Used boundary (Front)
    private CacheNode lruAnchor; // Least Recently Used boundary (Back)

    public LRUCache(int capacity) {
        this.maxCapacity = capacity;
        this.keyToNodeMap = new HashMap<>();

        // Initialize empty cache boundaries
        this.mruAnchor = new CacheNode(0, 0); 
        this.lruAnchor = new CacheNode(0, 0); 

        // Connect the boundaries directly to each other
        this.mruAnchor.next = this.lruAnchor;
        this.lruAnchor.prev = this.mruAnchor;
    }

    // Helper: Severs a node's ties to its current position in the list
    private void detachNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: Inserts a node directly after the MRU Anchor
    private void markAsMostRecentlyUsed(CacheNode node) {
        node.next = mruAnchor.next;
        node.prev = mruAnchor;

        mruAnchor.next.prev = node;
        mruAnchor.next = node;
    }

    public int get(int key) {
        if (!keyToNodeMap.containsKey(key)) {
            return -1;
        }

        CacheNode accessedNode = keyToNodeMap.get(key);

        // State update: The node was just used, so it becomes the new MRU
        detachNode(accessedNode);
        markAsMostRecentlyUsed(accessedNode);

        return accessedNode.value;
    }

    public void put(int key, int value) {
        if (keyToNodeMap.containsKey(key)) {
            // Update existing node and refresh its MRU status
            CacheNode existingNode = keyToNodeMap.get(key);
            existingNode.value = value;

            detachNode(existingNode);
            markAsMostRecentlyUsed(existingNode);
        } else {
            // Insert entirely new node
            CacheNode newNode = new CacheNode(key, value);
            keyToNodeMap.put(key, newNode);
            markAsMostRecentlyUsed(newNode);

            // Policy enforcement: Evict the LRU node if capacity is breached
            if (keyToNodeMap.size() > maxCapacity) {
                CacheNode leastRecentlyUsedNode = lruAnchor.prev;
                
                detachNode(leastRecentlyUsedNode);
                keyToNodeMap.remove(leastRecentlyUsedNode.key);
            }
        }
    }
}