//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 示例 1: 
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 说明: 
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。 
// Related Topics 堆 分治算法 
// 👍 913 👎 0


package leetcode.editor.cn;

import com.sun.jnlp.JNLPRandomAccessFileNSBImpl;

import java.util.Random;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        System.out.println(solution.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 快速选择算法
            int n = nums.length;
            int l = 0;
            int r = n - 1;
            int target = n - k;
            while (true) {
                int correctIdx = partition(nums, l, r);
                if (correctIdx == target) {
                    return nums[target];
                } else if (correctIdx < target) {
                    l = correctIdx + 1;
                } else {
                    r = correctIdx - 1;
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            // 随机选取轴
            if (left < right) {
                Random random = new Random();
                int randomIdx = left + random.nextInt(right - left + 1);
                swap(nums, left, randomIdx);
            }
            int pivot = nums[left];
            int l = left;
            int r = right;
            while (l < r) {
                while (l < r && nums[r] >= pivot) {
                    r--;
                }
                if (l < r) {
                    nums[l] = nums[r];
                    l++;
                }
                while (l < r && nums[l] <= pivot) {
                    l++;
                }
                if (l < r) {
                    nums[r] = nums[l];
                    r--;
                }
            }
            nums[l] = pivot;
            return l;
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}