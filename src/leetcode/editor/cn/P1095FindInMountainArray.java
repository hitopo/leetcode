//（这是一个 交互式问题 ） 
//
// 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 target 最小 的下标 index 
//值。 
//
// 如果不存在这样的下标 index，就请返回 -1。 
//
// 
//
// 何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件： 
//
// 首先，A.length >= 3 
//
// 其次，在 0 < i < A.length - 1 条件下，存在 i 使得： 
//
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
//
// 
//
// 你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据： 
//
// 
// MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始） 
// MountainArray.length() - 会返回该数组的长度 
// 
//
// 
//
// 注意： 
//
// 对 MountainArray.get 发起超过 100 次调用的提交将被视为错误答案。此外，任何试图规避判题系统的解决方案都将会导致比赛资格被取消。 
//
// 为了帮助大家更好地理解交互式问题，我们准备了一个样例 “答案”：https://leetcode-cn.com/playground/RKhe3ave，请
//注意这 不是一个正确答案。 
//
// 
// 
//
// 
//
// 示例 1： 
//
// 输入：array = [1,2,3,4,5,3,1], target = 3
//输出：2
//解释：3 在数组中出现了两次，下标分别为 2 和 5，我们返回最小的下标 2。 
//
// 示例 2： 
//
// 输入：array = [0,1,2,4,2,1], target = 3
//输出：-1
//解释：3 在数组中没有出现，返回 -1。
// 
//
// 
//
// 提示： 
//
// 
// 3 <= mountain_arr.length() <= 10000 
// 0 <= target <= 10^9 
// 0 <= mountain_arr.get(index) <= 10^9 
// 
// Related Topics 数组 二分查找 交互 
// 👍 130 👎 0


package leetcode.editor.cn;

import structure.MountainArray;
import structure.MountainArrayImpl;

//Java：山脉数组中查找目标值
public class P1095FindInMountainArray {
    public static void main(String[] args) {
        Solution solution = new P1095FindInMountainArray().new Solution();
        // TO TEST
        MountainArray mountainArray = new MountainArrayImpl(new int[]{1, 2, 3, 4, 5, 3, 1});
        System.out.println(solution.findInMountainArray(3, mountainArray));
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * // This is MountainArray's API interface.
     * // You should not implement it, or speculate about its implementation
     * interface MountainArray {
     * public int get(int index) {}
     * public int length() {}
     * }
     */

    class Solution {
        public int findInMountainArray(int target, MountainArray mountainArr) {
            // 先找到峰值，再去左右区间分别查找
            int len = mountainArr.length();
            int peek = findPeek(mountainArr, len);
            // 左半边查找
            int leftIdx = upBinarySearch(mountainArr, 0, peek, target);
            if (leftIdx >= 0) {
                return leftIdx;
            }
            // 右半边查找
            int rightIdx = downBinarySearch(mountainArr, peek + 1, len - 1, target);
            return rightIdx;
        }

        private int downBinarySearch(MountainArray mountainArr, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midVal = mountainArr.get(mid);
                if (target == midVal) {
                    return mid;
                } else if (target < midVal) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -1;
        }

        private int upBinarySearch(MountainArray mountainArr, int left, int right, int target) {
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midVal = mountainArr.get(mid);
                if (target == midVal) {
                    return mid;
                } else if (target < midVal) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return -1;
        }

        private int findPeek(MountainArray mountainArr, int len) {
            int l = 0;
            int r = len - 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}