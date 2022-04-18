package easy;

import Solution.easy.PalindromeNumber;
import Utility.JHMTemplate;
import org.junit.Test;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@State(Scope.Thread)
public class PalindromeNumberTest extends JHMTemplate {
    public PalindromeNumberTest() {
        this.questionName = "palindromeNumber";
        this.iterationSize = 2;
    }

    @Override
    public Object lineToObject(String line, int lineCountMod) {
        if (lineCountMod == 0){
            return Integer.valueOf(line);
        } else {
            return Boolean.valueOf(line);
        }
//        return null;
    }

    @Test
    public void palindromeNumberTest() {
        initializeData();
        List<Object> input = dataList.get(0);
        List<Object> solution = dataList.get(1);
        for (int i = 0; i < input.size(); i++) {
            Boolean actual = PalindromeNumber.isPalindrome((Integer) input.get(i));
            assertEquals(solution.get(i), actual);
        }
    }

    @Test
    public void palindromeNumberTestJava67() {
        initializeData();
        List<Object> input = dataList.get(0);
        List<Object> solution = dataList.get(1);
        for (int i = 0; i < input.size(); i++) {
            Boolean actual = PalindromeNumber.isPalindromeJava67((Integer) input.get(i));
//            System.out.println(actual +":"+(Integer) input.get(i));
            assertEquals(solution.get(i), actual);
        }
    }

    @Setup
    public void prepare() {
        initializeData();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void isPalindrome(){
        List<Object> input = dataList.get(0);
        List<Object> solution = dataList.get(1);
        for (int i = 0; i < input.size(); i++) {
            Boolean actual = PalindromeNumber.isPalindrome((Integer) input.get(i));
            assertEquals(solution.get(i), actual);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void isPalindromeJava67(){
        List<Object> input = dataList.get(0);
        List<Object> solution = dataList.get(1);
        for (int i = 0; i < input.size(); i++) {
            Boolean actual = PalindromeNumber.isPalindromeJava67((Integer) input.get(i));
            assertEquals(solution.get(i), actual);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void isPalindromeJava67Optimize(){
        List<Object> input = dataList.get(0);
        List<Object> solution = dataList.get(1);
        for (int i = 0; i < input.size(); i++) {
            Boolean actual = PalindromeNumber.isPalindromeJava67Optimize((Integer) input.get(i));
            assertEquals(solution.get(i), actual);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void isPalindromeCodeRecipe(){
        List<Object> input = dataList.get(0);
        List<Object> solution = dataList.get(1);
        for (int i = 0; i < input.size(); i++) {
            Boolean actual = PalindromeNumber.isPalindromeCodeRecipe((Integer) input.get(i));
            assertEquals(solution.get(i), actual);
        }
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(PalindromeNumberTest.class.getSimpleName())
                .forks(1)
                .build();
        new Runner(opt).run();
    }
}
