package Solution;

public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        } else if (len == 2) {
            if (s.charAt(0) == s.charAt(1)) {
                return s;
            } else {
                return s.substring(0, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {

        }
        return "";
    }
}
