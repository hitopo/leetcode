//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000 
// 
// 👍 289 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

//Java：排序数组
public class P912SortAnArray {
    public static void main(String[] args) {
        Solution solution = new P912SortAnArray().new Solution();
        // TO TEST
        System.out.println(Arrays.toString(solution.sortArray(new int[]{1, 4, 5, 2, 3})));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] sortArray(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
            return nums;
        }

        private void quickSort(int[] nums, int l, int r) {
            if (l >= r) {
                return;
            }
            int sortedIdx = partition(nums, l, r);
            quickSort(nums, l, sortedIdx - 1);
            quickSort(nums, sortedIdx + 1, r);
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[l];
            while (l < r) {
                while (l < r && nums[r] >= pivot) {
                    r--;
                }
                nums[l] = nums[r];
                while (l < r && nums[l] <= pivot) {
                    l++;
                }
                nums[r] = nums[l];
            }
            nums[l] = pivot;
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}