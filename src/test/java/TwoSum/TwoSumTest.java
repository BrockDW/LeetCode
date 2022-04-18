package TwoSum;
import Solution.easy.TwoSum;
import org.junit.Test;

import static org.junit.Assert.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@State(Scope.Thread)
public class TwoSumTest {

    ArrayList<Integer[]> nums;
    ArrayList<Integer> target;
    Integer[][] solution = {
            {1,2},
            {0,1},
            {0,1},
    };

    public void initializeData(){
        nums = new ArrayList<>();
        target = new ArrayList<>();
        try {
            int lineCounter = 0;
            File myObj = new File("src/test/java/TwoSum/twoSumTest.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if(lineCounter % 2 == 0){
                    String[] splitedInt = data.split(",");
                    Integer[] parsedInt = new Integer[splitedInt.length];
                    for(int i = 0; i < splitedInt.length; i++){
                        parsedInt[i] = Integer.parseInt(splitedInt[i]);
                    }
                    nums.add(parsedInt);
                } else {
                    target.add(Integer.parseInt(data));
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
    public void twoSumTest(){
        initializeData();
        for(int i = 0; i < target.size(); i++){
            Integer[] result = TwoSum.twoSum(nums.get(i), target.get(i));
            Integer[] expected = solution[i];
            assert result != null;
            assertTrue((result[0].equals(expected[0]) && result[1].equals(expected[1]))
                    ||
                    (result[1].equals(expected[0]) && result[0].equals(expected[1])));
        }
    }


    @Benchmark
    public void twoSumOne(){
        for(int i = 0; i < target.size(); i++){
            Integer[] result = TwoSum.twoSum(nums.get(i), target.get(i));
        }
    }

    @Benchmark
    public void twoSumTwo(){
        for(int i = 0; i < target.size(); i++){
            Integer[] result = TwoSum.twoSumDoubleForLoop(nums.get(i), target.get(i));
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(TwoSumTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
