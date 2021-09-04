//请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。 
//
// 实现 LFUCache 类： 
//
// 
// LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象 
// int get(int key) - 如果键存在于缓存中，则获取键的值，否则返回 -1。 
// void put(int key, int value) - 如果键已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量时，则应该在插入新项之
//前，使最不经常使用的项无效。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最近最久未使用 的键。 
// 
//
// 注意「项的使用次数」就是自插入该项以来对其调用 get 和 put 函数的次数之和。使用次数会在对应项被移除后置为 0 。 
//
// 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。 
//
// 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。 
//
// 
//
// 示例： 
//
// 
//输入：
//["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", 
//"get"]
//[[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
//输出：
//[null, null, null, 1, null, -1, 3, null, -1, 3, 4]
//
//解释：
//// cnt(x) = 键 x 的使用计数
//// cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
//LFUCache lFUCache = new LFUCache(2);
//lFUCache.put(1, 1);   // cache=[1,_], cnt(1)=1
//lFUCache.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
//lFUCache.get(1);      // 返回 1
//                      // cache=[1,2], cnt(2)=1, cnt(1)=2
//lFUCache.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
//                      // cache=[3,1], cnt(3)=1, cnt(1)=2
//lFUCache.get(2);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,1], cnt(3)=2, cnt(1)=2
//lFUCache.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
//                      // cache=[4,3], cnt(4)=1, cnt(3)=2
//lFUCache.get(1);      // 返回 -1（未找到）
//lFUCache.get(3);      // 返回 3
//                      // cache=[3,4], cnt(4)=1, cnt(3)=3
//lFUCache.get(4);      // 返回 4
//                      // cache=[3,4], cnt(4)=2, cnt(3)=3 
//
// 
//
// 提示： 
//
// 
// 0 <= capacity, key, value <= 10⁴ 
// 最多调用 10⁵ 次 get 和 put 方法 
// 
//
// 
//
// 进阶：你可以为这两种操作设计时间复杂度为 O(1) 的实现吗？ 
// Related Topics 设计 哈希表 链表 双向链表 👍 430 👎 0


package leetcode.editor.cn;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

//Java：LFU 缓存
public class P460LfuCache {
    public static void main(String[] args) {
        // TO TEST
        new P460LfuCache().test();
    }

    public void test() {
        LFUCache cache = new LFUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class LFUCache {
        private Map<Integer, Node> valueMap;
        // 从最小的freq的链表中的头部删除，尾部插入
        private Map<Integer, LinkedHashSet<Node>> freqMap;
        private int capacity;
        // 最小的频率
        private int minFreq;

        public LFUCache(int capacity) {
            valueMap = new HashMap<>(capacity);
            freqMap = new HashMap<>(capacity);
            this.capacity = capacity;
            minFreq = 0;
        }

        public int get(int key) {
            Node node = valueMap.get(key);
            if (node == null) {
                return -1;
            }
            freqInc(node);
            return node.value;
        }

        public void put(int key, int value) {
            if (this.capacity == 0) {
                return;
            }
            Node node = valueMap.get(key);
            if (node != null) {
                // 直接覆盖就好，覆盖的时候频率是直接加上去的，而不是重新开始
                node.value = value;
                freqInc(node);
            } else {
                if (valueMap.size() == this.capacity) {
                    Node deleteNode = removeNode();
                    valueMap.remove(deleteNode.key);
                }
                // 新建一个节点
                Node newNode = new Node(key, value);
                valueMap.put(key, newNode);
                addNode(newNode);
            }
        }

        private void addNode(Node node) {
            // 找到对应的freq，尾部插入
            freqMap.computeIfAbsent(node.freq, LinkedHashSet::new).add(node);
            minFreq = 1;
        }

        private Node removeNode() {
            // 从minFreq中的头部删除节点
            LinkedHashSet<Node> minFreqNodeSet = freqMap.get(minFreq);
            Node firstNode = minFreqNodeSet.iterator().next();
            minFreqNodeSet.remove(firstNode);
            return firstNode;
        }

        // 调整Node节点对应的频次+1
        private void freqInc(Node node) {
            int freq = node.freq;
            LinkedHashSet<Node> freqNodeSet = freqMap.get(freq);
            freqNodeSet.remove(node);
            // 在添加节点访问次数的时候维护minFreq的定义，注意更新的时机，每次也都是+1
            if (freq == minFreq && freqNodeSet.size() == 0) {
                minFreq = freq + 1;
            }
            node.freq++;
            freqMap.computeIfAbsent(freq + 1, LinkedHashSet::new).add(node);
        }
    }

    class Node {
        public int key;
        public int value;
        public int freq;

        public Node() {
            freq = 1;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    /**
     * Your LFUCache object will be instantiated and called as such:
     * LFUCache obj = new LFUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */
    //leetcode submit region end(Prohibit modification and deletion)

}