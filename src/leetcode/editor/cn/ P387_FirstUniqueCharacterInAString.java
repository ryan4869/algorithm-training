//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。 
//
// 
//
// 示例： 
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
// 
//
// 
//
// 提示：你可以假定该字符串只包含小写字母。 
// Related Topics 队列 哈希表 字符串 计数 
// 👍 493 👎 0

 
package leetcode.editor.cn;
 
//字符串中的第一个唯一字符

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

class P387_FirstUniqueCharacterInAString{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P387_FirstUniqueCharacterInAString().new Solution();
	 	 String s = "loveleetcode";
	 	 solution.firstUniqChar(s);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        Integer[] arr = new Integer[26];
        // 遍历字符串
        for (int i = 0; i < s.length() ; i++) {
            char c = s.charAt(i);
            if (arr[c-'a'] == null){
                arr[c-'a'] = i;
            }else {
                arr[c-'a'] = -1;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i] != -1){
                res = Math.min(res,arr[i]);
            }
        }
        return res==Integer.MAX_VALUE?-1:res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}