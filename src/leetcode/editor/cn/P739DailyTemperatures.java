//请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
// 
//
// 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2
//, 1, 1, 0, 0]。 
//
// 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。 
// Related Topics 栈 哈希表 
// 👍 755 👎 0


package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//Java：每日温度
public class P739DailyTemperatures {
    public static void main(String[] args) {
        Solution solution = new P739DailyTemperatures().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            // 单调栈
            int n = temperatures.length;
            int[] res = new int[n];
            // 维护一个单调递减的单调栈
            Deque<Integer> stack = new ArrayDeque<>();
            for (int i = 0; i < temperatures.length; i++) {
                // 单调递减的单调栈遇到
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    int temp = stack.pop();
                    res[temp] = i - temp;
                }
                stack.push(i);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}