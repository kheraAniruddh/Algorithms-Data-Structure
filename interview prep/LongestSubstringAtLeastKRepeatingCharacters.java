/**
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
**/

class LongestSubstringAtLeastKRepeatingCharacters {
    
    public int findSubstring(String s, int start, int end, int k) {
        if(k==1) return s.length();
        if(start==end) return 0;
        int j=start;
        int[] freq =  new int[26];
        
        while(j<end) {
            freq[s.charAt(j)-'a']++;
            j++;
        }
     
        j=start;
        while(j<end) {
            if(freq[s.charAt(j)-'a']<k) {
                return Math.max(findSubstring(s, j+1, end, k), findSubstring(s, start, j, k));
            }
            else
                j++;
        }
        return end-start;
    }
    
    public int longestSubstring(String s, int k) {
        if(s==null || s.length()==0)
            return 0;
        
        return findSubstring(s,0, s.length(), k);
    }
}