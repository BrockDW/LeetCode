package LongestSubstringWithoutRepeatingCharacters;

import Solution.AddTwoNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LongestSubstringWithoutRepeatingCharactersTest {
    ArrayList<String> inputString;
    ArrayList<Integer> output;

    public void initializeData() {
        inputString = new ArrayList<>();
        output = new ArrayList<>();
        try {
            int lineCounter = 0;
            File myObj = new File("src/test/java/LongestSubstringWithoutRepeatingCharacters/longestSubstringWithoutRepeatingCharactersTest.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int lineCounterModulo = lineCounter % 2;
                if (lineCounterModulo == 0) {
                    inputString.add(data);
                } else {
                    output.add(Integer.parseInt(data));
                }
                lineCounter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharactersTest test = new LongestSubstringWithoutRepeatingCharactersTest();
        test.initializeData();
    }
}
