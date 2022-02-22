package Solution;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {

        return 0;
    }

    public int lengthOfLongestSubstringLoop(String s) {
        if (s.equals("")){
            return 0;
        }
        int maxLenCount = 0;
        int curCount = 1;

        int i = 0;

        for (int j = i + 1; j < s.length(); j++){
            if (maxLenCount < curCount){
                maxLenCount = curCount;
            }
            curCount++;

            for(int z = i; z < j; z++){
                if(s.charAt(j) == s.charAt(z)){
                    i = z + 1;
                    curCount = j - z;
                    break;
                }
            }
        }

        if (maxLenCount < curCount){
            maxLenCount = curCount;
        }
        return maxLenCount;
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

//        String inputFour = "aab";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputFour));

//        String inputFive = "bwf";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputFive));
//
//        String inputSix = "dvdf";
//        System.out.println(lswrc.lengthOfLongestSubstringLoop(inputSix));
    }
}
