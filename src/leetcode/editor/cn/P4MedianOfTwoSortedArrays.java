//给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
// Related Topics 数组 二分查找 分治算法 
// 👍 3565 👎 0


package leetcode.editor.cn;

//Java：寻找两个正序数组的中位数
public class P4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int n = nums1.length + nums2.length;
            if (n % 2 != 0) {
                return findKth(nums1, nums2, n / 2);
            } else {
                return (findKth(nums1, nums2, n / 2 - 1) + findKth(nums1, nums2, n / 2)) / 2.0;
            }
        }

        /**
         * 返回两个有序数组的 kth 元素，k从0开始
         */
        private double findKth(int[] nums1, int[] nums2, int k) {
            int i = 0;
            int j = 0;
            int step = 0;
            while (i < nums1.length && j < nums2.length) {
                if (step == k) {
                    return Math.min(nums1[i], nums2[j]);
                }
                if (nums1[i] < nums2[j]) {
                    i++;
                } else {
                    j++;
                }
                step++;
            }
            while (i < nums1.length) {
                if (step == k) {
                    return nums1[i];
                }
                i++;
                step++;
            }
            while (j < nums2.length) {
                if (step == k) {
                    return nums2[j];
                }
                j++;
                step++;
            }
            return -1;
        }

    }
    //leetcode submit region end(Prohibit modification and deletion)

}