package LongestSubstringWithoutRepeatingCharacters;

import Solution.medium.LongestSubstringWithoutRepeatingCharacters;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

@State(Scope.Thread)
public class LongestSubstringWithoutRepeatingCharactersTest {
    ArrayList<String> inputString;
    ArrayList<Integer> result;

    public void initializeData() {
        inputString = new ArrayList<>();
        result = new ArrayList<>();
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
                    result.add(Integer.parseInt(data));
                }
                lineCounter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Setup
    public void prepare() {
        initializeData();
    }

    @Test
    public void test(){
        initializeData();
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        for (int i = 0; i < result.size(); i++) {
            Integer actual = lswrc.lengthOfLongestSubstringLoop(inputString.get(i));
            assertEquals(result.get(i), actual);
        }
    }

    @Benchmark
    public void longestSubstringSingleLoop(){
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        for (int i = 0; i < result.size(); i++) {
            Integer actual = lswrc.lengthOfLongestSubstringLoop(inputString.get(i));
        }
    }

    @Benchmark
    public void longestSubstringTripleLoop(){
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        for (int i = 0; i < result.size(); i++) {
            Integer actual = lswrc.lengthOfLongestSubstringTripleLoop(inputString.get(i));
        }

    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(LongestSubstringWithoutRepeatingCharactersTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
