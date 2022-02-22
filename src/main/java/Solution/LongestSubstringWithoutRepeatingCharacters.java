package Solution;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    //    https://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstringTripleLoop(String s) {
        int n = s.length();

        // Result
        int res = 0;

        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++)
                if (areDistinct(s, i, j))
                    res = Math.max(res, j - i + 1);

        return res;
    }

    private Boolean areDistinct(String str, int i, int j) {

        // Note : Default values in visited are false
        boolean[] visited = new boolean[26];

        for (int k = i; k <= j; k++) {
            boolean b = visited[str.charAt(k) - 'a'];
            if (b)
                return false;

            b = true;
        }
        return true;
    }

    public int lengthOfLongestSubstringLoop(String s) {
        if (s.equals("")) {
            return 0;
        }
        int maxLenCount = 0;
        int curCount = 1;

        int i = 0;

        for (int j = i + 1; j < s.length(); j++) {
            if (maxLenCount < curCount) {
                maxLenCount = curCount;
            }
            curCount++;

            for (int z = i; z < j; z++) {
                if (s.charAt(j) == s.charAt(z)) {
                    i = z + 1;
                    curCount = j - z;
                    break;
                }
            }
        }

        if (maxLenCount < curCount) {
            maxLenCount = curCount;
        }
        return maxLenCount;
    }

    public int lengthOfLongestSubstringAnirudh(String s) {
        // Base condition
        if (s == null || s.equals("")) {
            return 0;
        }
        // Starting window index
        int start = 0;
        // Ending window index
        int end = 0;
        // Maximum length of substring
        int maxLength = 0;
        // This set will store the unique characters
        Set<Character> uniqueCharacters = new HashSet<>();
        // Loop for each character in the string
        while (end < s.length()) {
            if (uniqueCharacters.add(s.charAt(end))) {
                end++;
                maxLength = Math.max(maxLength, uniqueCharacters.size());
            } else {
                uniqueCharacters.remove(s.charAt(start));
                start++;
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
//        String input = "abcabcbb";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(input));
//
//        String inputTwo = "bbbbb";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputTwo));
//
//        String inputThree = "pwwkew";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputThree));
//
//        String inputFour = "aab";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputFour));
//
//        String inputFive = "bwf";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputFive));
//
//        String inputSix = "dvdf";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputSix));
    }
}
