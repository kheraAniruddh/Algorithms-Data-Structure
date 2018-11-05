import java.util.*;

class WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        for(String str: wordDict)
            set.add(str);
        return helper(s,0, set);
    }
   public static boolean helper(String s, int start,Set<String> wordDict) {  
    if(start==s.length()) return true;
        for(int i=start;i<s.length();i++) {
            if(wordDict.contains(s.substring(start,i+1)) && helper(s,i+1, wordDict)) {
                return true;
            }
        }
        return false;
   }
   public static void main(String[] args) {
         List<String> dict = new ArrayList<>();
         dict.add("apple"); dict.add("pen");
       System.out.println(WordBreak.wordBreak("applepenapple",dict));
   }
}