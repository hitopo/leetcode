//给定一个非负整数的数据流输入 a1，a2，…，an，…，将到目前为止看到的数字总结为不相交的区间列表。 
//
// 例如，假设数据流中的整数为 1，3，7，2，6，…，每次的总结为： 
//
// [1, 1]
//[1, 1], [3, 3]
//[1, 1], [3, 3], [7, 7]
//[1, 3], [7, 7]
//[1, 3], [6, 7]
// 
//
// 
//
// 进阶： 
//如果有很多合并，并且与数据流的大小相比，不相交区间的数量很小，该怎么办? 
//
// 提示： 
//特别感谢 @yunhong 提供了本问题和其测试用例。 
// Related Topics 二分查找 Ordered Map 
// 👍 60 👎 0


package leetcode.editor.cn;

import java.util.*;

//Java：将数据流变为多个不相交区间
public class P352DataStreamAsDisjointIntervals {
    public static void main(String[] args) {
        // TO TEST
        new P352DataStreamAsDisjointIntervals().test();
    }

    private void test() {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class SummaryRanges {
        private Set<Integer> set;

        /**
         * Initialize your data structure here.
         */
        public SummaryRanges() {
            set = new TreeSet<>();
        }

        public void addNum(int val) {
            set.add(val);
        }

        public int[][] getIntervals() {
            List<int[]> list = new ArrayList<>();
            // 合并区间
            Iterator<Integer> iter = set.iterator();
            int begin = iter.next();
            int end = begin;
            while (iter.hasNext()) {
                int num = iter.next();
                if (num == end + 1) {
                    end++;
                } else {
                    list.add(new int[]{begin, end});
                    begin = num;
                    end = begin;
                }
            }
            list.add(new int[]{begin, end});
            return list.toArray(new int[0][]);
        }
    }

    /**
     * Your SummaryRanges object will be instantiated and called as such:
     * SummaryRanges obj = new SummaryRanges();
     * obj.addNum(val);
     * int[][] param_2 = obj.getIntervals();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}