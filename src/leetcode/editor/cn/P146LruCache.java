//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制 。 
//
// 
// 
// 实现 LRUCache 类： 
//
// 
// LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存 
// int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。 
// void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上
//限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
// 
//
// 
// 
// 
//
// 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例： 
//
// 
//输入
//["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
//输出
//[null, null, null, 1, null, -1, null, -1, 3, 4]
//
//解释
//LRUCache lRUCache = new LRUCache(2);
//lRUCache.put(1, 1); // 缓存是 {1=1}
//lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
//lRUCache.get(1);    // 返回 1
//lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
//lRUCache.get(2);    // 返回 -1 (未找到)
//lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
//lRUCache.get(1);    // 返回 -1 (未找到)
//lRUCache.get(3);    // 返回 3
//lRUCache.get(4);    // 返回 4
// 
//
// 
//
// 提示： 
//
// 
// 1 <= capacity <= 3000 
// 0 <= key <= 3000 
// 0 <= value <= 104 
// 最多调用 3 * 104 次 get 和 put 
// 
// Related Topics 设计 
// 👍 1376 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：LRU 缓存机制
public class P146LruCache {
    public static void main(String[] args) {
        // TO TEST
    }

    public void put(int key, int value) {
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private Map<Integer, Integer> map;
        // 双向链表虚拟头尾
        private DoubleList doubleList;
        private int capacity;

        public LRUCache(int capacity) {
            map = new HashMap<>();
            doubleList = new DoubleList();
            this.capacity = capacity;
        }

        public int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }
            doubleList.visit(key);
            return map.get(key);
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                // 访问了节点
                doubleList.visit(key);
            } else {
                if (map.size() == capacity) {
                    // 若满，移除最久远的那个节点，就是双向链表的头结点
                    DoubleListNode node = doubleList.removeHead();
                    map.remove(node.val);
                }
                // 在双向链表的末尾新增节点
                doubleList.addToTail(key);
            }
            map.put(key, value);
        }
    }

    /**
     * 双向链表
     */
    class DoubleList {
        public DoubleListNode head;
        public DoubleListNode tail;

        public DoubleList() {
            head = new DoubleListNode();
            tail = new DoubleListNode();
            head.next = tail;
            tail.prev = head;
        }

        public void moveNodeToTail(DoubleListNode node) {
            //从节点中剥离
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 加入到尾部
            addToTail(node);
        }

        public DoubleListNode searchNode(int val) {
            DoubleListNode p = head;
            while (p != tail) {
                if (p.val == val) {
                    return p;
                }
                p = p.next;
            }
            return null;
        }

        public void visit(int val) {
            // 双向链表中间存的是key，Map中存放的是key-value
            DoubleListNode keyNode = searchNode(val);
            // 访问key，就将对应的key节点移动到双向链表的末尾
            moveNodeToTail(keyNode);
        }

        public DoubleListNode removeHead() {
            DoubleListNode firstKeyNode = head.next;
            head.next = firstKeyNode.next;
            firstKeyNode.next.prev = head;
            return firstKeyNode;
        }

        public void addToTail(int val) {
            DoubleListNode newNode = new DoubleListNode(val);
            addToTail(newNode);
        }

        private void addToTail(DoubleListNode node) {
            node.prev = tail.prev;
            node.next = tail;
            tail.prev.next = node;
            tail.prev = node;
        }
    }

    /**
     * 双向链表节点
     */
    class DoubleListNode {
        public int val;
        public DoubleListNode prev;
        public DoubleListNode next;

        public DoubleListNode() {
        }

        public DoubleListNode(int val) {
            this.val = val;
        }
    }
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)
}


