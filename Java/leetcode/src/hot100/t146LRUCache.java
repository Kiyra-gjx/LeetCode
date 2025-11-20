package hot100;

import java.util.HashMap;

public class t146LRUCache {
    static class LRUCache {
        static class DLinkedNode {
            int key;
            int val;
            DLinkedNode prev;
            DLinkedNode next;
            DLinkedNode() {}
            DLinkedNode(int key, int val) {this.key = key; this.val = val; }
        }

        private int size = 0;
        private int capacity = 0;
        private HashMap<Integer, DLinkedNode> cache = new HashMap<> ();
        DLinkedNode head, tail;

        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkedNode();
            tail = new DLinkedNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkedNode node = cache.get(key);
            if (node == null) {
                return -1;
            }
            moveToHead(node);
            return node.val;
        }

        public void put(int key, int value) {
            DLinkedNode node = cache.get(key);
            if (node != null) {
                // 如果存在这个值，直接修改
                node.val = value;
                // 移到头节点
                moveToHead(node);
            } else {
                // 如果 key 不存在，创建一个新的节点
                DLinkedNode newNode = new DLinkedNode(key, value);
                // 添加进 hash 表
                cache.put(key, newNode);
                // 将新节点添加到头部
                addToHead(newNode);
                size++;
                if (size > capacity) {
                    // 如果容量超出最大容量
                    size = capacity;
                    // 移除尾节点
                    DLinkedNode removedNode = removeTailNode();
                    // 将节点从哈希表中移除
                    cache.remove(removedNode.key);
                }
            }
        }

        private void removeNode(DLinkedNode node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
        }

        private void moveToHead(DLinkedNode node) {
            removeNode(node);
            addToHead(node);
        }

        private DLinkedNode removeTailNode() {
            DLinkedNode res = tail.prev;
            removeNode(res);
            return res;
        }

        private void addToHead(DLinkedNode node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
    }

    public static void main(String[] args) {
        LRUCache lru = new LRUCache(1);
        lru.put(2, 1);
        int ans = lru.get(2);
        System.out.println(ans);
    }
}
