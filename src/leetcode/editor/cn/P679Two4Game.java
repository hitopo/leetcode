//你有 4 张写有 1 到 9 数字的牌。你需要判断是否能通过 *，/，+，-，(，) 的运算得到 24。 
//
// 示例 1: 
//
// 输入: [4, 1, 8, 7]
//输出: True
//解释: (8-4) * (7-1) = 24
// 
//
// 示例 2: 
//
// 输入: [1, 2, 1, 2]
//输出: False
// 
//
// 注意: 
//
// 
// 除法运算符 / 表示实数除法，而不是整数除法。例如 4 / (1 - 2/3) = 12 。 
// 每个运算符对两个数进行运算。特别是我们不能用 - 作为一元运算符。例如，[1, 1, 1, 1] 作为输入时，表达式 -1 - 1 - 1 - 1 是不允
//许的。 
// 你不能将数字连接在一起。例如，输入为 [1, 2, 1, 2] 时，不能写成 12 + 12 。 
// 
// Related Topics 深度优先搜索 
// 👍 292 👎 0


package leetcode.editor.cn;

//Java：24 点游戏
public class P679Two4Game {
    public static void main(String[] args) {
        Solution solution = new P679Two4Game().new Solution();
        // TO TEST
        System.out.println(solution.judgePoint24(new int[]{8, 1, 6, 6}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean judgePoint24(int[] nums) {
            double[] a = new double[]{nums[0], nums[1], nums[2], nums[3]};
            return helper(a);
        }

        private boolean helper(double[] nums) {
            if (nums.length == 1) {
                return Math.abs(nums[0] - 24) < 0.001;
            }
            // 从数组中选择两个数进行计算
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    // 注意这两个数-和/是有顺序的
                    double[] tempNums = new double[nums.length - 1];
                    // 先把没选中的先拷贝下来
                    for (int k = 0, idx = 0; k < nums.length; k++) {
                        if (k != i && k != j) {
                            tempNums[idx] = nums[k];
                            idx++;
                        }
                    }
                    for (double newNum : compute(nums[i], nums[j])) {
                        // 最后一个数放前面选中的两个数的计算结果
                        tempNums[tempNums.length - 1] = newNum;
                        if (helper(tempNums)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }

        private double[] compute(double num1, double num2) {
            return new double[]{num1 + num2, num1 - num2, num2 - num1, num1 * num2, num1 / num2, num2 / num1};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}