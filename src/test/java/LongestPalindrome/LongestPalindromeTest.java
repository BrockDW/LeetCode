package LongestPalindrome;

import Solution.AddTwoNumbers;
import Solution.LongestPalindromicSubstring;
import Utility.JHMTemplate;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class LongestPalindromeTest extends JHMTemplate {
    public LongestPalindromeTest() {
        this.questionName = "longestPalindrome";
        this.iterationSize = 2;
    }


    @Override
    public Object lineToObject(String line, int lineCountMod) {
        return line;
    }

    @Test
    public void addTwoNumberTest() {
        initializeData();
//        LongestPalindromicSubstring solution = new LongestPalindromicSubstring();
//        List<Object> result = dataList.get(dataList.size() - 1);
        List<Object> input = dataList.get(0);
        List<Object> solution = dataList.get(1);
        for (int i = 0; i < input.size(); i++) {
            String actual = LongestPalindromicSubstring.longestPalindrome((String) input.get(i));
            assertEquals(solution.get(i), actual);
        }
    }
}
