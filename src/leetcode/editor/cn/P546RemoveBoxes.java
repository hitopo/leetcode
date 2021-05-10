//给出一些不同颜色的盒子，盒子的颜色由数字表示，即不同的数字表示不同的颜色。 
//
// 你将经过若干轮操作去去掉盒子，直到所有的盒子都去掉为止。每一轮你可以移除具有相同颜色的连续 k 个盒子（k >= 1），这样一轮之后你将得到 k * k 
//个积分。 
//
// 当你将所有盒子都去掉之后，求你能获得的最大积分和。 
//
// 
//
// 示例 1： 
//
// 
//输入：boxes = [1,3,2,2,2,3,4,3,1]
//输出：23
//解释：
//[1, 3, 2, 2, 2, 3, 4, 3, 1] 
//----> [1, 3, 3, 4, 3, 1] (3*3=9 分) 
//----> [1, 3, 3, 3, 1] (1*1=1 分) 
//----> [1, 1] (3*3=9 分) 
//----> [] (2*2=4 分)
// 
//
// 示例 2： 
//
// 
//输入：boxes = [1,1,1]
//输出：9
// 
//
// 示例 3： 
//
// 
//输入：boxes = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= boxes.length <= 100 
// 1 <= boxes[i] <= 100 
// 
// Related Topics 深度优先搜索 动态规划 
// 👍 289 👎 0


package leetcode.editor.cn;

//Java：移除盒子
public class P546RemoveBoxes {
    public static void main(String[] args) {
        Solution solution = new P546RemoveBoxes().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private int[][][] memo;

        public int removeBoxes(int[] boxes) {
            int n = boxes.length;
            memo = new int[n][n][n];
            return calcScore(0, n - 1, 0, boxes);
        }

        /**
         * 计算最大分数
         * @param l     左边界
         * @param r     右边界
         * @param k     左边界开始有k个数字和左边界元素相同
         * @param boxes 盒子
         * @return 分数
         */
        private int calcScore(int l, int r, int k, int[] boxes) {
            if (l > r) {
                return 0;
            }
            if (memo[l][r][k] != 0) {
                return memo[l][r][k];
            }
            while (l < r && boxes[l] == boxes[l + 1]) {
                l++;
                k++;
            }
            // 此时l和l+1的元素肯定不同，消除k+1个连续的元素
            int res = (k + 1) * (k + 1) + calcScore(l + 1, r, 0, boxes);
            for (int i = l + 1; i <= r; i++) {
                if (boxes[i] == boxes[l]) {
                    // 如果后面存在元素和当前元素相同，那么可能先消除这两者中间的可能会比较好，所以要找一个最大值
                    res = Math.max(res, calcScore(l + 1, i - 1, 0, boxes) + calcScore(i, r, k + 1, boxes));
                }
            }
            memo[l][r][k] = res;
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}