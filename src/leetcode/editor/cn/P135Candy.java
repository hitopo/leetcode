//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 479 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：分发糖果
public class P135Candy {
    public static void main(String[] args) {
        Solution solution = new P135Candy().new Solution();
        // TO TEST
        System.out.println(solution.candy(new int[]{1, 0, 2}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int candy(int[] ratings) {
            // 分发糖果
            // 从左到右和从右到左分别都要满足这个规则
            int n = ratings.length;
            if (n == 0) {
                return 0;
            }
            int[] candies = new int[n];
            candies[0] = 1;
            candies[n - 1] = 1;
            // 先满足左边的规则
            for (int i = 1; i < n; i++) {
                candies[i] = ratings[i] > ratings[i - 1] ? candies[i - 1] + 1 : 1;
            }
            for (int i = n - 2; i >= 0; i--) {
                if (ratings[i] > ratings[i + 1]) {
                    candies[i] = Math.max(candies[i], candies[i + 1] + 1);
                }
            }
            return Arrays.stream(candies).sum();
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}