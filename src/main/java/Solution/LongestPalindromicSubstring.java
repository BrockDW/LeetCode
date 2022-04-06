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

        if (s.charAt(0) == s.charAt(1)){
            longest = s.substring(0,2);
            longestLen = 2;
        }



        int prevCharIndex = 1;

        int count = 0;

        boolean started = false;
        boolean breaked = false;

        for (int i = 2; i < s.length(); i++) {
            char curChar = s.charAt(i);

            if (!started){
                if (curChar == s.charAt(prevCharIndex - 1)){
                    prevCharIndex-=2;
                    count+=2;
                    started = true;
                } else if (curChar == s.charAt(prevCharIndex)){
                    prevCharIndex--;
                    count+=1;
                    started = true;
                } else  {
                    prevCharIndex++;
                }
            } else{
                if (curChar == s.charAt(prevCharIndex)){
                    prevCharIndex--;
                    count+=1;
                } else {
                    breaked = true;
                    started = false;
                }
            }

            if (prevCharIndex < 0){
                prevCharIndex++;
                if (count>=longestLen){
                    longest = s.substring(prevCharIndex, i+1);
                    longestLen = count;
                }
                prevCharIndex = i;
//                count = 0;
            }

            if (breaked){
                prevCharIndex++;
                if (count>=longestLen){
                    longest = s.substring(prevCharIndex, i);
                    longestLen = count;
                }
                i--;
                prevCharIndex = i;
                count = 0;
                breaked = false;
                started = false;
            }

            if(i == s.length() - 1){
                if (started){
                    prevCharIndex++;
                    if (count>=longestLen){
                        longest = s.substring(prevCharIndex, i+1);
                        longestLen = count;
                    }
                }
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaa"));
    }
}
