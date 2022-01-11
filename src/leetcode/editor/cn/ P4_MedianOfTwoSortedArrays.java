//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 算法的时间复杂度应该为 O(log (m+n)) 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
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
// Related Topics 数组 二分查找 分治 
// 👍 4841 👎 0

 
package leetcode.editor.cn;
 
//寻找两个正序数组的中位数

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目九：
 * 一个数据流中，随时可以取得中位数
 *
 * 思路：
 * 创建一个大根堆和一个小根堆，获得大根堆的堆顶元素，
 * 每遍历一个数据，将其和堆顶元素作比较，
 * 如果其小于堆顶元素则add进大根堆，否则add进小根堆，
 * 之后比较大小根堆大小，大小差异大于等于2，则将大小根堆调平
 */
class P4_MedianOfTwoSortedArrays{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P4_MedianOfTwoSortedArrays().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		PriorityQueue<Integer> smallHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		});

		PriorityQueue<Integer> bigHeap = new PriorityQueue<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1;
			}
		});

		for (int i = 0; i < nums1.length ; i++) {
			if (bigHeap!=null && bigHeap.size()!=0){
				process(bigHeap,smallHeap,nums1[i]);
			}else {
				bigHeap.add(nums1[i]);
			}

		}
		for (int i = 0; i < nums2.length ; i++) {
			if (bigHeap!=null && bigHeap.size()!=0){
				process(bigHeap,smallHeap,nums2[i]);
			}else {
				bigHeap.add(nums2[i]);
			}
		}
		if (bigHeap.size()>smallHeap.size()){
			return bigHeap.peek();
		}
		if (smallHeap.size()>bigHeap.size()){
			return smallHeap.peek();
		}
		return (bigHeap.peek()+smallHeap.peek())/2.0;
	}

	public void process(PriorityQueue<Integer> bigHeap,PriorityQueue<Integer> smallHeap,int cur){
		Integer head = bigHeap.peek();
		if (cur<head){
			bigHeap.add(cur);
		}else {
			smallHeap.add(cur);
		}
		if ((bigHeap.size()-smallHeap.size())>1){
			smallHeap.add(bigHeap.poll());
		}
		if ((smallHeap.size()-bigHeap.size())>1){
			bigHeap.add(smallHeap.poll());
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}