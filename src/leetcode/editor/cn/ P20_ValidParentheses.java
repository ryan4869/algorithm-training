//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2912 👎 0

 
package leetcode.editor.cn;
 
//有效的括号

import java.util.LinkedList;
import java.util.Stack;

class P20_ValidParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P20_ValidParentheses().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
				stack.add(s.charAt(i));
			}else {
				if (stack.isEmpty()){ // 测试用例 "]"
					return false;
				}
				Character pop = stack.pop();
				if (!((pop == '(' && s.charAt(i) == ')' )|| (pop == '[' && s.charAt(i) == ']' )|| (pop == '{' && s.charAt(i) == '}'))){
					return false;
				}
			}
		}
		if (!stack.isEmpty()){ // 测试用例 "(("
			return false;
		}
		return true;
	}

}
//leetcode submit region end(Prohibit modification and deletion)

}