//升序排列的整数数组 nums 在预先未知的某个点上进行了旋转（例如， [0,1,2,4,5,6,7] 经旋转后可能变为 [4,5,6,7,0,1,2] ）。
// 
//
// 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// nums 肯定会在某个点上旋转 
// -10^4 <= target <= 10^4 
// 
// Related Topics 数组 二分查找 
// 👍 1125 👎 0


package leetcode.editor.cn;

//Java：搜索旋转排序数组
public class P33SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new P33SearchInRotatedSortedArray().new Solution();
        // TO TEST
        System.out.println(solution.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int search(int[] nums, int target) {
            // 时间复杂度就已经限定了该题只能用二分查找，限定了不存在重复的元素
            // 实际上不管怎么旋转，旋转之后的数组肯定存在某一半是有序的
            int l = 0;
            int r = nums.length - 1;
            // 这题是查找，只剩一个位置也需要检查
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (target == nums[mid]) {
                    return mid;
                }
                if (nums[l] <= nums[mid]) {
                    // 前半部分有序，这里必须也要和开头比较，如[4,5,6,7,0,1,2]查找0，前半部分有序，但是0并不在4,5,6,7中
                    // 所以缩半区间的时候左右区间都要比较
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else if (nums[mid] < nums[r]) {
                    // 后半部分有序
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}