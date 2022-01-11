//给定一个字符串S，通过将字符串S中的每个字母转变大小写，我们可以获得一个新的字符串。返回所有可能得到的字符串集合。 
//
// 
//
// 示例：
//输入：S = "a1b2"
//输出：["a1b2", "a1B2", "A1b2", "A1B2"]
//
//输入：S = "3z4"
//输出：["3z4", "3Z4"]
//
//输入：S = "12345"
//输出：["12345"]
// 
//
// 
//
// 提示： 
//
// 
// S 的长度不超过12。 
// S 仅由数字和字母组成。 
// 
// Related Topics 位运算 字符串 回溯 
// 👍 328 👎 0

 
package leetcode.editor.cn;
 
//字母大小写全排列

import java.util.ArrayList;
import java.util.List;

class P784_LetterCasePermutation{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P784_LetterCasePermutation().new Solution();
	 	 String s = "a1b2";
	 	 solution.letterCasePermutation(s);
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCasePermutation(String s) {
    	List<String> res = new ArrayList<>();
    	String path  = new String();
		dfs(path,s,0,res);
		return res;
    }

	private void dfs(String path,String s,int depth,List<String> res) {
		if (depth == s.length()){
			res.add(path);
			return;
		}
		char cur = s.charAt(depth++);
		String newPath = null;
		if (Character.isLetter(cur)){
			// 只有大写和小写两种选择
			char[] chars = new char[2];
			chars[0] = cur;
			chars[1] = Character.isLowerCase(cur)?Character.toUpperCase(cur):Character.toLowerCase(cur);
			for (int i = 0; i < chars.length ; i++) {
				cur = chars[i];
				newPath = path+cur;
				dfs(newPath,s,depth,res);
			}
		}else {
			newPath = path+cur;
			dfs(newPath,s,depth,res);
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}