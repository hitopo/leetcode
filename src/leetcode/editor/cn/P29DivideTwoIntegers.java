//给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。 
//
// 返回被除数 dividend 除以除数 divisor 得到的商。 
//
// 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2 
//
// 
//
// 示例 1: 
//
// 输入: dividend = 10, divisor = 3
//输出: 3
//解释: 10/3 = truncate(3.33333..) = truncate(3) = 3 
//
// 示例 2: 
//
// 输入: dividend = 7, divisor = -3
//输出: -2
//解释: 7/-3 = truncate(-2.33333..) = -2 
//
// 
//
// 提示： 
//
// 
// 被除数和除数均为 32 位有符号整数。 
// 除数不为 0。 
// 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231, 231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。 
// 
// Related Topics 数学 二分查找 
// 👍 572 👎 0


package leetcode.editor.cn;

//Java：两数相除
public class P29DivideTwoIntegers {
    public static void main(String[] args) {
        Solution solution = new P29DivideTwoIntegers().new Solution();
        // TO TEST
        System.out.println(solution.divide(Integer.MIN_VALUE, -1));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int divide(int dividend, int divisor) {
            if (dividend == 0) {
                return 0;
            }
            if (divisor == 1) {
                return dividend;
            }
            if (divisor == -1) {
                // Integer.MIN_VALUE反过来会溢出，对于这样的情况，返回Integer.MAX_VALUE
                if (dividend == Integer.MIN_VALUE) {
                    return Integer.MAX_VALUE;
                }
                return -dividend;
            }
            long a = dividend;
            long b = divisor;
            int sign = 1;
            if (a > 0 && b < 0 || a < 0 && b > 0) {
                sign = -1;
            }
            // 全部转换成正数计算
            a = a > 0 ? a : -a;
            b = b > 0 ? b : -b;
            long res = div(a, b);
            if (sign > 0) {
                return res > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) res;
            }
            return (int) -res;
        }

        // 计算的关键所在
        private long div(long a, long b) {
            if (a < b) {
                return 0;
            }
            long count = 1;
            long tb = b;
            while (tb + tb <= a) {
                // 最小解和当前测试的值同时翻倍
                count = count + count;
                tb += tb;
            }
            return count + div(a - tb, b);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}