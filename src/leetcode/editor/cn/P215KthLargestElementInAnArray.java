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

import java.util.Random;

//Java：数组中的第K个最大元素
public class P215KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new P215KthLargestElementInAnArray().new Solution();
        // TO TEST
        System.out.println(solution.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Random random = new Random(System.currentTimeMillis());

        public int findKthLargest(int[] nums, int k) {
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            int target = len - k;
            while (true) {
                // index表示的是快速排序一次的完成的那个下标元素
                int sortedIdx = partition(nums, left, right);
                if (sortedIdx < target) {
                    left = sortedIdx + 1;
                } else if (sortedIdx > target) {
                    right = sortedIdx - 1;
                } else {
                    return nums[sortedIdx];
                }
            }
        }

        private int partition(int[] nums, int left, int right) {
            // // 随机选择一个元素作为轴
            // if (left > right) {
            //     int randomIdx = left + random.nextInt(right - left + 1);
            //     // 选择过轴之后要把轴元素交换到最左边
            //     swap(nums, left, randomIdx);
            // }
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
            // 最终排序好的元素是位置l的元素
            return l;
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}