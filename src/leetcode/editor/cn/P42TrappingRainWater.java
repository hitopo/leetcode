//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 
// 👍 2055 👎 0


package leetcode.editor.cn;

//Java：接雨水
public class P42TrappingRainWater {
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int trap(int[] height) {
            int n = height.length;
            if (n <= 2) {
                return 0;
            }
            int res = 0;
            // 借用动态规划的思想直接用空间换取时间事先存好每个位置上的左右两边最高的墙的高度
            int[] maxLeft = new int[n];
            int[] maxRight = new int[n];
            maxLeft[0] = 0;
            maxRight[n - 1] = 0;
            for (int i = 1; i < height.length; i++) {
                // 这里比较的是height[i-1]因为maxLeft[i-1]没有考虑i-1位置的墙高度
                maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
            }
            for (int i = n - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
            }
            for (int i = 1; i < n - 1; i++) {
                int minHeight = Math.min(maxLeft[i], maxRight[i]);
                if (minHeight > height[i]) {
                    res += minHeight - height[i];
                }
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}