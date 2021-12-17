//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"  a a  ab
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"  p pw wk
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 104 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 
// 👍 6470 👎 0

 
package leetcode.editor.cn;
 
//无重复字符的最长子串

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

class P3_LongestSubstringWithoutRepeatingCharacters{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P3_LongestSubstringWithoutRepeatingCharacters().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int lengthOfLongestSubstring(String s) {
		HashMap<Character,Integer> hashMap = new HashMap<>();
		int left = 0;//子串左边界
		int right = 0;//子串右边界
		int maxLength = 0;
		while (right<s.length()){
			char c = s.charAt(right);
			Integer integer = hashMap.get(c);
			// 存在重复字符
			if (integer != null){
				hashMap.remove(c);
				left = Math.max(left,integer.intValue()+1);
			}
			hashMap.put(s.charAt(right),right);
			right++;
			maxLength = Math.max(maxLength,right-left);
		}
		return maxLength;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}