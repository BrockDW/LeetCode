package AddTwoNumbers;

import Solution.medium.AddTwoNumbers;
import org.junit.Test;

import static org.junit.Assert.*;

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

@State(Scope.Thread)
public class AddTwoNumbersTest {
    ArrayList<AddTwoNumbers.ListNode> inputNumberOne;
    ArrayList<AddTwoNumbers.ListNode> inputNumberTwo;

    ArrayList<AddTwoNumbers.ListNode> result;

    public void initializeData() {
        inputNumberOne = new ArrayList<>();
        inputNumberTwo = new ArrayList<>();
        result = new ArrayList<>();
        try {
            int lineCounter = 0;
            File myObj = new File("src/test/java/AddTwoNumbers/addTwoNumbersTest.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] splitedInt = data.split(",");
                AddTwoNumbers.ListNode resultListNode = new AddTwoNumbers.ListNode();
                AddTwoNumbers.ListNode start = resultListNode;
                for (String s : splitedInt) {
                    AddTwoNumbers.ListNode next = new AddTwoNumbers.ListNode(Integer.parseInt(s));
                    start.next = next;
                    start = next;
                }

                int lineCounterModulo = lineCounter % 3;
                if (lineCounterModulo == 0) {
                    inputNumberOne.add(resultListNode.next);
                } else if (lineCounterModulo == 1) {
                    inputNumberTwo.add(resultListNode.next);
                } else {
                    result.add(resultListNode.next);
                }
                lineCounter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Test
    public void addTwoNumberTest() {
        initializeData();
        AddTwoNumbers atn = new AddTwoNumbers();
        for (int i = 0; i < result.size(); i++) {
            AddTwoNumbers.ListNode actual = atn.addTwoNumbers(inputNumberOne.get(i), inputNumberTwo.get(i));
            assertEquals(result.get(i), actual);
        }
    }

    @Setup
    public void prepare() {
        initializeData();
    }

    @Benchmark
    public void addTwoNumbersBenchmark(){
        AddTwoNumbers atn = new AddTwoNumbers();
        for (int i = 0; i < result.size(); i++) {
            AddTwoNumbers.ListNode actual = atn.addTwoNumbers(inputNumberOne.get(i), inputNumberTwo.get(i));
        }
    }

    @Benchmark
    public void addTwoNumbersKaustavBenchmark(){
        AddTwoNumbers atn = new AddTwoNumbers();
        for (int i = 0; i < result.size(); i++) {
            AddTwoNumbers.ListNode actual = atn.addTwoNumbersKaustavGurey(inputNumberOne.get(i), inputNumberTwo.get(i));
        }
    }

    @Benchmark
    public void addTwoNumbersAnirudhBenchmark(){
        AddTwoNumbers atn = new AddTwoNumbers();
        for (int i = 0; i < result.size(); i++) {
            AddTwoNumbers.ListNode actual = atn.addTwoNumbersAnirudh(inputNumberOne.get(i), inputNumberTwo.get(i));
        }
    }



    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(AddTwoNumbersTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
