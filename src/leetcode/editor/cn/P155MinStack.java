//设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。 
//
// 
// push(x) —— 将元素 x 推入栈中。 
// pop() —— 删除栈顶的元素。 
// top() —— 获取栈顶元素。 
// getMin() —— 检索栈中的最小元素。 
// 
//
// 
//
// 示例: 
//
// 输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//输出：
//[null,null,null,null,-3,null,0,-2]
//
//解释：
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin();   --> 返回 -3.
//minStack.pop();
//minStack.top();      --> 返回 0.
//minStack.getMin();   --> 返回 -2.
// 
//
// 
//
// 提示： 
//
// 
// pop、top 和 getMin 操作总是在 非空栈 上调用。 
// 
// Related Topics 栈 设计 
// 👍 902 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;

//Java：最小栈
public class P155MinStack {
    public static void main(String[] args) {
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class MinStack {
        private Deque<Integer> dataStack;
        private Deque<Integer> helperStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            dataStack = new ArrayDeque<>();
            helperStack = new ArrayDeque<>();
        }

        public void push(int val) {
            // 数字栈和辅助栈都会增加元素
            dataStack.push(val);
            if (helperStack.isEmpty() || helperStack.peek() >= val) {
                helperStack.push(val);
            } else {
                // 这里又添加一次当前最小值是为了保证两个栈的数字元素个数相等
                helperStack.push(helperStack.peek());
            }
        }

        public void pop() {
            if (!dataStack.isEmpty()) {
                dataStack.pop();
                helperStack.pop();
            }
            throw new RuntimeException("栈为空，不能用pop()操作!");
        }

        public int top() {
            if (!dataStack.isEmpty()) {
                return dataStack.peek();
            }
            throw new RuntimeException("栈为空，不能用top()操作!");
        }


        public int getMin() {
            if (!helperStack.isEmpty()) {
                return helperStack.peek();
            }
            throw new RuntimeException("栈为空，不能用getMin()操作!");
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(val);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
    //leetcode submit region end(Prohibit modification and deletion)

}