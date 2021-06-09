//给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 
//
// 注意：1 ≤ k ≤ n ≤ 109。 
//
// 示例 : 
//
// 
//输入:
//n: 13   k: 2
//
//输出:
//10
//
//解释:
//字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
// 👍 213 👎 0


package leetcode.editor.cn;

//Java：字典序的第K小数字
public class P440KThSmallestInLexicographicalOrder {
    public static void main(String[] args) {
        Solution solution = new P440KThSmallestInLexicographicalOrder().new Solution();
        // TO TEST
        System.out.println(solution.findKthNumber(13, 3));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthNumber(int n, int k) {
            int cur = 1;
            k--;
            while (k > 0) {
                long step = 0;
                long first = cur;
                long last = cur + 1;
                while (first <= n) {
                    step += Math.min(n + 1, last) - first;
                    first *= 10;
                    last *= 10;
                }
                if (step <= k) {
                    // 不在子树中
                    cur++;
                    k -= step;
                } else {
                    cur *= 10;
                    k--;
                }
            }
            return cur;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}