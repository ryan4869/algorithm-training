//给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。 
//
// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "anagram", t = "nagaram"
//输出: true
// 
//
// 示例 2: 
//
// 
//输入: s = "rat", t = "car"
//输出: false 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length, t.length <= 5 * 104 
// s 和 t 仅包含小写字母 
// 
//
// 
//
// 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？ 
// Related Topics 哈希表 字符串 排序
// P383 赎金信
// 👍 481 👎 0

 
package leetcode.editor.cn;
 
//有效的字母异位词
class P242_ValidAnagram{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P242_ValidAnagram().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isAnagram(String s, String t) {
    	if (s.length() != t.length()){
    		return false;
		}
		// 用数组代替hashMap
		int[] arr = new int[26];
		// 遍历字符串
		for (int i = 0; i < s.length() ; i++) {
			char c = s.charAt(i);
			arr[c-'a'] = arr[c-'a']+1;
		}
		for (int i = 0; i < t.length(); i++) {
			char c = t.charAt(i);
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