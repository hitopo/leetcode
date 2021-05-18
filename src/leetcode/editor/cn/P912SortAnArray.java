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
            // 几种排序方法
            quickSort(nums);
            // bubbleSort(nums);
            // heapSort(nums);
            return nums;
        }

        /**
         * 堆排序
         */
        private void heapSort(int[] nums) {
            int n = nums.length;
            // 创建起大顶堆
            buildMaxHeap(nums);
            for (int i = n - 1; i > 0; i--) {
                // 将最大值和末尾位置元素互换
                int temp = nums[0];
                nums[0] = nums[i];
                nums[i] = temp;
                heapify(nums, 0, i);
            }
        }

        private void buildMaxHeap(int[] nums) {
            for (int i = nums.length / 2 - 1; i >= 0; i--) {
                // 从最后一个非叶子节点从下往上，从右往左调整结构
                // 因为堆是完全二叉树，而完全二叉树的最后一个非叶子节点就是(n/2)-1
                heapify(nums, i, nums.length);
            }
        }

        /**
         * 调整数组，以重新满足最大堆的标准，当前父节点的位置是i，len是堆的总长度
         * @param nums    数组
         * @param rootIdx 父节点位置
         * @param len     堆的总长度
         */
        private void heapify(int[] nums, int rootIdx, int len) {
            int leftIdx = rootIdx * 2 + 1;
            int rightIdx = rootIdx * 2 + 2;
            int maxIdx = rootIdx;
            if (leftIdx < len && nums[leftIdx] > nums[maxIdx]) {
                maxIdx = leftIdx;
            }
            if (rightIdx < len && nums[rightIdx] > nums[maxIdx]) {
                maxIdx = rightIdx;
            }
            // 如果当前父节点不满足条件，就需要调整
            if (maxIdx != rootIdx) {
                // 大节点交换到上面
                int temp = nums[rootIdx];
                nums[rootIdx] = nums[maxIdx];
                nums[maxIdx] = temp;
                // 换下来的maxIdx的新元素可能很小，可能会需要继续调整
                heapify(nums, maxIdx, len);
            }
        }

        /**
         * 冒泡排序，稳定排序
         */
        private void bubbleSort(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                boolean hasSwap = false;
                for (int j = 0; j < n - i - 1; j++) {
                    if (nums[j] > nums[j + 1]) {
                        hasSwap = true;
                        int temp = nums[j];
                        nums[j] = nums[j + 1];
                        nums[j + 1] = temp;
                    }
                }
                if (!hasSwap) {
                    break;
                }
            }
        }

        /**
         * 选择排序，非稳定排序
         */
        public void selectionSort(int[] nums) {
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] < nums[minIdx]) {
                        minIdx = j;
                    }
                }
                int temp = nums[i];
                nums[i] = nums[minIdx];
                nums[minIdx] = temp;
            }
        }

        /**
         * 插入排序，稳定排序
         */
        public void insertionSort(int[] nums) {
            int n = nums.length;
            for (int i = 1; i < n; i++) {
                int num = nums[i];
                int k = i - 1;
                while (k >= 0 && nums[k] > num) {
                    nums[k + 1] = nums[k];
                    k--;
                }
                nums[k + 1] = num;
            }
        }

        /**
         * 希尔排序，不稳定排序
         */
        public void shellSort(int[] nums) {
            int n = nums.length;
            int gap = n / 2;
            // gap是间隔的意思，有多少gap就分成多少组
            while (gap > 0) {
                for (int i = gap; i < n; i++) {
                    int num = nums[i];
                    int j = i - 1;
                    while (j >= 0 && nums[j] > num) {
                        nums[j + 1] = nums[j];
                        j--;
                    }
                    nums[j + 1] = num;
                }
                gap /= 2;
            }
        }

        /**
         * 快速排序，非稳定排序
         */
        public void quickSort(int[] nums) {
            quickSort(nums, 0, nums.length - 1);
        }

        private void quickSort(int[] nums, int l, int r) {
            if (l < r) {
                int idx = partition(nums, l, r);
                quickSort(nums, l, idx - 1);
                quickSort(nums, idx + 1, r);
            }
        }

        private int partition(int[] nums, int l, int r) {
            int pivot = nums[l];
            int i = l;
            int j = r;
            while (i < j) {
                while (i < j && nums[j] >= pivot) {
                    j--;
                }
                nums[i] = nums[j];
                while (i < j && nums[i] <= pivot) {
                    i++;
                }
                nums[j] = nums[i];
            }
            nums[i] = pivot;
            return i;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}