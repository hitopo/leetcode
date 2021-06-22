//设计一个支持在平均 时间复杂度 O(1) 下， 执行以下操作的数据结构。 
//
// 注意: 允许出现重复元素。 
//
// 
// insert(val)：向集合中插入元素 val。 
// remove(val)：当 val 存在时，从集合中移除一个 val。 
// getRandom：从现有集合中随机获取一个元素。每个元素被返回的概率应该与其在集合中的数量呈线性相关。 
// 
//
// 示例: 
//
// // 初始化一个空的集合。
//RandomizedCollection collection = new RandomizedCollection();
//
//// 向集合中插入 1 。返回 true 表示集合不包含 1 。
//collection.insert(1);
//
//// 向集合中插入另一个 1 。返回 false 表示集合包含 1 。集合现在包含 [1,1] 。
//collection.insert(1);
//
//// 向集合中插入 2 ，返回 true 。集合现在包含 [1,1,2] 。
//collection.insert(2);
//
//// getRandom 应当有 2/3 的概率返回 1 ，1/3 的概率返回 2 。
//collection.getRandom();
//
//// 从集合中删除 1 ，返回 true 。集合现在包含 [1,2] 。
//collection.remove(1);
//
//// getRandom 应有相同概率返回 1 和 2 。
//collection.getRandom();
// 
// Related Topics 设计 数组 哈希表 
// 👍 216 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：O(1) 时间插入、删除和获取随机元素 - 允许重复
public class P381InsertDeleteGetrandomO1DuplicatesAllowed {
    public static void main(String[] args) {
        // TO TEST
        new P381InsertDeleteGetrandomO1DuplicatesAllowed().test();
    }

    private void test() {
        RandomizedCollection collection = new RandomizedCollection();
        System.out.println(collection.insert(4));
        System.out.println(collection.insert(3));
        System.out.println(collection.insert(4));
        System.out.println(collection.insert(2));
        System.out.println(collection.insert(4));
        System.out.println(collection.remove(4));
        System.out.println(collection.remove(3));
        System.out.println(collection.remove(4));
        System.out.println(collection.remove(4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class RandomizedCollection {
        private List<Integer> list;
        private Map<Integer, HashSet<Integer>> map;
        private Random random;

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            list = new ArrayList<>();
            map = new HashMap<>();
            random = new Random();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            list.add(val);
            if (map.containsKey(val)) {
                map.get(val).add(list.size() - 1);
                // 这里实际上有可能是之前存在val的，但是之后又删除了，所以必须要判断长度
                return map.get(val).size() == 1;
            } else {
                HashSet<Integer> idxSet = new HashSet<>();
                idxSet.add(list.size() - 1);
                map.put(val, idxSet);
                return true;
            }
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            Set<Integer> idxSet = map.get(val);
            if (idxSet == null || idxSet.size() == 0) {
                return false;
            }
            int lastVal = list.get(list.size() - 1);
            int deleteValIdx = idxSet.iterator().next();
            list.set(deleteValIdx, lastVal);
            Set<Integer> lastValIdxSet = map.get(lastVal);
            lastValIdxSet.remove(list.size() - 1);
            lastValIdxSet.add(deleteValIdx);
            idxSet.remove(deleteValIdx);
            list.remove(list.size() - 1);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            int randomIdx = random.nextInt(list.size());
            return list.get(randomIdx);
        }
    }

    /**
     * Your RandomizedCollection object will be instantiated and called as such:
     * RandomizedCollection obj = new RandomizedCollection();
     * boolean param_1 = obj.insert(val);
     * boolean param_2 = obj.remove(val);
     * int param_3 = obj.getRandom();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}