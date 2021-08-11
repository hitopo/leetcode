package leetcode.editor.cn;

//Java：乘积小于K的子数组
public class P713SubarrayProductLessThanK {
    public static void main(String[] args) {
        Solution solution = new P713SubarrayProductLessThanK().new Solution();
        // TO TEST
        System.out.println(solution.numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numSubarrayProductLessThanK(int[] nums, int k) {
            // 又是一题滑动窗口的典型题目，因为都是正整数，所以乘积只能越来越大，所以可以用子数组解决
            if (k == 0 || k == 1) {
                // 不可能乘积比0或者1还要小
                return 0;
            }
            int l = 0;
            int r = 0;
            int product = 1;
            int cnt = 0;
            while (r < nums.length) {
                // 拓展右边界
                product *= nums[r];
                while (product >= k) {
                    // 收缩左边界
                    product /= nums[l];
                    l++;
                }
                // 这题特殊的地方在于收缩完之后再去计算组合数字, 相当于每次扩展右边界的时候添加新的数目
                cnt += r - l + 1;
                r++;
            }
            return cnt;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}