//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 堆 设计 
// 👍 413 👎 0


package leetcode.editor.cn;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

//Java：数据流的中位数
public class P295FindMedianFromDataStream {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        private Queue<Integer> leftMaxHeap;
        private Queue<Integer> rightMinHeap;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            // 左半边是大顶堆，右半边是小顶堆，PriorityQueue默认是小顶堆
            leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
            rightMinHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 这里添加的num需要左右两个堆都要去更新一下
            leftMaxHeap.add(num);
            rightMinHeap.add(leftMaxHeap.poll());
            // 此时左边的净变化是0，右边是+1，所以右边可能会越来越多，所以需要判断右边是否需要拿元素到左边
            if (rightMinHeap.size() > leftMaxHeap.size()) {
                leftMaxHeap.add(rightMinHeap.poll());
            }
        }

        public double findMedian() {
            if (leftMaxHeap.size() == rightMinHeap.size()) {
                return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
            } else {
                return leftMaxHeap.peek();
            }
        }
    }

    /**
     * Your MedianFinder object will be instantiated and called as such:
     * MedianFinder obj = new MedianFinder();
     * obj.addNum(num);
     * double param_2 = obj.findMedian();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}