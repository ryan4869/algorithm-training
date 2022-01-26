//给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。 
//
// 如果可以，返回 true ；否则返回 false 。 
//
// magazine 中的每个字符只能在 ransomNote 中使用一次。 
//
// 
//
// 示例 1： 
//
// 
//输入：ransomNote = "a", magazine = "b"
//输出：false
// 
//
// 示例 2： 
//
// 
//输入：ransomNote = "aa", magazine = "ab"
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：ransomNote = "aa", magazine = "aab"
//输出：true
// 
//
// 
//
// 提示： 
//
// 
// 1 <= ransomNote.length, magazine.length <= 105 
// ransomNote 和 magazine 由小写英文字母组成 
// 
// Related Topics 哈希表 字符串 计数 
// 👍 266 👎 0

 
package leetcode.editor.cn;
 
//赎金信

import java.util.HashMap;

class P383_RansomNote{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P383_RansomNote().new Solution();
		 String ransomNote = "a";
		 String magazine = "b";
		 solution.canConstruct(ransomNote,magazine);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    	// 用数组代替hashMap
		int[] arr = new int[26];
		// 遍历字符串
		for (int i = 0; i < magazine.length() ; i++) {
			char c = magazine.charAt(i);
			arr[c-'a'] = arr[c-'a']+1;
		}
		for (int i = 0; i < ransomNote.length(); i++) {
			char c = ransomNote.charAt(i);
			if (arr[c-'a'] > 0){
				arr[c-'a'] = arr[c-'a']-1;
			}else{
				return false;
			}
		}
		return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}