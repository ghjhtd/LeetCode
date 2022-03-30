package leetcode.editor.cn;

//给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。 
//
// 美式键盘 中： 
//
// 
// 第一行由字符 "qwertyuiop" 组成。 
// 第二行由字符 "asdfghjkl" 组成。 
// 第三行由字符 "zxcvbnm" 组成。 
// 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["Hello","Alaska","Dad","Peace"]
//输出：["Alaska","Dad"]
// 
//
// 示例 2： 
//
// 
//输入：words = ["omk"]
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：words = ["adsdf","sfd"]
//输出：["adsdf","sfd"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 20 
// 1 <= words[i].length <= 100 
// words[i] 由英文字母（小写和大写字母）组成 
// 
// Related Topics 数组 哈希表 字符串 👍 204 👎 0

import java.util.*;

public class KeyboardRow {
    public static void main(String[] args) {
        Solution solution = new KeyboardRow().new Solution();
        for (String s : solution.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})) {
            System.out.println(s);
        }
    }


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findWords(String[] words) {
        List<String>ans=new ArrayList<>();
        String str1="qwertyuiopQWERTYUIOP";
        String str2="asdfghjklASDFGHJKL";
        String str3="zxcvbnmZXCVBNM";
        Set<Character>set1=new HashSet<>();
        Set<Character>set2=new HashSet<>();
        Set<Character>set3=new HashSet<>();
        for(int i=0;i<str1.length();++i) {set1.add(str1.charAt(i));}
        for(int i=0;i<str2.length();++i) {
            set2.add(str2.charAt(i));
        }
        for(int i=0;i<str3.length();++i) {
            set3.add(str3.charAt(i));
        }
        for(String word:words){
            int n1=0,n2=0,len=word.length();
            char cc=word.charAt(0);
            if(set1.contains(cc)) {n1=1;n2=n1;}
            else if(set2.contains(cc)) {n1=2;n2=n1;}
            else if(set3.contains(cc)) {n1=3;n2=n1;}
            for(int i=1;i<len&&n1==n2;++i){
                char c=word.charAt(i);
                if(set1.contains(c)) {
                    n2 = 1;
                }
                else if(set2.contains(c)) {
                    n2 = 2;
                }
                else if(set3.contains(c)) {
                    n2 = 3;
                }
            }
            if(n1==n2){
                ans.add(word);
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}