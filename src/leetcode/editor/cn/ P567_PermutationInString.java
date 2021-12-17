//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 
// 👍 498 👎 0

 
package leetcode.editor.cn;
 
//字符串的排列

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

class P567_PermutationInString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P567_PermutationInString().new Solution();

	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean checkInclusion(String s1, String s2) {
//		Set<Character> occ = new HashSet<>();
//		int length = s1.length();
//		int n = s2.length();
//		int p = 0;
//		int q = p + length;
//		int rk = 0;
//		while (rk+length-1 < n){
//			//每次都把s1放到Hashmap里
//			for (int i = 0; i < s1.length() ; i++) {
//				occ.add(s1.charAt(i));
//			}
//			for (int i = q; i <q ; i++) {
//				occ.remove(s2.charAt(i));
//			}
//			if (occ.isEmpty()){
//				return true;
//			}
//			occ.clear();
//		}
//		return false;
		if (s2.length()<s1.length()){
			return false;
		}
		int n = s1.length();
		int left = 0;
		int right = 0;
		HashMap<Character,Integer> hashMap1 = new HashMap();
		HashMap<Character,Integer> hashMap2 = new HashMap();
		for (int i = 0; i < n; i++) {
			char c = s1.charAt(i);
			Integer integer = hashMap1.getOrDefault(c,0);
			hashMap1.put(c,integer.intValue()+1);
		}
		while (right < s2.length()){
			while (right-left<n){
				char c = s2.charAt(right++);
				Integer integer = hashMap2.getOrDefault(c,0);
				hashMap2.put(c,integer.intValue()+1);
			}
			if (hashMap2.equals(hashMap1)){
				return true;
			}
			if (right >= s2.length()){
				return false;
			}
			if (s2.charAt(left)==s2.charAt(right)){
			}else {
				// 左边界元素，将hashmap中值-1
				int leftValue = hashMap2.getOrDefault(s2.charAt(left), 0).intValue();
				if (leftValue == 1){
					hashMap2.remove(s2.charAt(left));
				}else {
					hashMap2.put(s2.charAt(left),leftValue-1);
				}
				// 右边界元素，将hashmap中值+1
				int rightValue = hashMap2.getOrDefault(s2.charAt(right), 0).intValue();
				hashMap2.put(s2.charAt(right),rightValue+1);
			}
			if (hashMap2.equals(hashMap1)){
				return true;
			}
			left++;
			right++;
		}
		return false;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}