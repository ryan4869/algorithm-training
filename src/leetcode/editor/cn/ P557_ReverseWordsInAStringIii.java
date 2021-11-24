//给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。 
//
// 
//
// 示例： 
//
// 输入："Let's take LeetCode contest"
//输出："s'teL ekat edoCteeL tsetnoc"
// 
//
// 
//
// 提示： 
//
// 
// 在字符串中，每个单词由单个空格分隔，并且字符串中不会有任何额外的空格。 
// 
// Related Topics 双指针 字符串 
// 👍 367 👎 0

 
package leetcode.editor.cn;
 
//反转字符串中的单词 III
 
class P557_ReverseWordsInAStringIii{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P557_ReverseWordsInAStringIii().new Solution();
	 }
//力扣代码
	//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
//    	String res = "";
//		String[] strings = s.split(" ");
//		for (int i = 0; i < strings.length; i++) {
//			char[] charArray = strings[i].toCharArray();
//			reverseString(charArray);
//			String str = String.copyValueOf(charArray);
//			res = res.concat(str);
//			if (i != strings.length-1){
//				res = res.concat(" ");
//			}
//		}
//		return res;
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        int end = 0;
        while (i<s.length()){
            int start = i;
            while (i<s.length() && s.charAt(i)!=' '){
                end = i;
                i++;
            }
            i = start;
            while (i>=start && i<=end){
                stringBuffer.append(s.charAt(end-(i-start)));
                i++;
            }
            if (i<s.length() && s.charAt(i)==' '){
                stringBuffer.append(" ");
                i++;
            }
        }

        return stringBuffer.toString();
	}

	public void reverseString(char[] s) {
		int p = 0;
		int q = s.length-1;
		while (p<q){
			char temp = s[p];
			s[p] = s[q];
			s[q] = temp;
			p++;
			q--;
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}