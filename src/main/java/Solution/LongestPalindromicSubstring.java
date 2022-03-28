package Solution;

public class LongestPalindromicSubstring {
    public static String longestPalindrome(String s) {
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

        String longest = "";
        int longestLen = 0;

        Character firstChar = s.charAt(0);
        Character secondChar = s.charAt(1);

        int firstCharIndex = 0;
        int secondCharIndex = 1;

        int prevCharIndex = 1;

        int count = 0;

        for (int i = 2; i < s.length(); i++) {
            Character curChar = s.charAt(i);

            if (curChar == s.charAt(prevCharIndex)){
                prevCharIndex--;
                count+=0;
            } else if (curChar == s.charAt(prevCharIndex - 1)){
                prevCharIndex-=2;
                count++;
            }
            System.out.println(curChar +":"+prevCharIndex+":"+i+":"+count);
            if (prevCharIndex<0){
                prevCharIndex++;
                if (count>=longestLen){
                    longest = s.substring(prevCharIndex, i+1);
                    longestLen = count;
                }
                prevCharIndex = i - count;
                count = 0;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        longestPalindrome("ababd");
    }
}
