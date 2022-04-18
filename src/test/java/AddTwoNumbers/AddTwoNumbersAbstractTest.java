package AddTwoNumbers;

import Solution.medium.AddTwoNumbers;
import Utility.JHMTemplate;
import org.junit.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.List;

import static org.junit.Assert.assertEquals;

@State(Scope.Thread)
public class AddTwoNumbersAbstractTest extends JHMTemplate {
    public AddTwoNumbersAbstractTest() {
        this.questionName = "addTwoNumbers";
        this.iterationSize = 3;
    }

    @Override
    public Object lineToObject(String line, int lineCountMod) {
        String[] splitedInt = line.split(",");
        AddTwoNumbers.ListNode resultListNode = new AddTwoNumbers.ListNode();
        AddTwoNumbers.ListNode start = resultListNode;
        for (String s : splitedInt) {
            AddTwoNumbers.ListNode next = new AddTwoNumbers.ListNode(Integer.parseInt(s));
            start.next = next;
            start = next;
        }
        return resultListNode;
    }

    @Setup
    public void prepare() {
        initializeData();
    }

    @Benchmark
    public void addTwoNumbersBenchmark(){
        AddTwoNumbers atn = new AddTwoNumbers();
        List<Object> result = dataList.get(dataList.size() - 1);
        List<Object> inputNumberOne = dataList.get(0);
        List<Object> inputNumberTwo = dataList.get(1);
        for (int i = 0; i < result.size(); i++) {
            AddTwoNumbers.ListNode actual = atn.addTwoNumbers((AddTwoNumbers.ListNode) inputNumberOne.get(i), (AddTwoNumbers.ListNode) inputNumberTwo.get(i));
        }
    }

    @Test
    public void addTwoNumberTest() {
        initializeData();
        AddTwoNumbers atn = new AddTwoNumbers();
        List<Object> result = dataList.get(dataList.size() - 1);
        List<Object> inputNumberOne = dataList.get(0);
        List<Object> inputNumberTwo = dataList.get(1);
        for (int i = 0; i < result.size(); i++) {
            AddTwoNumbers.ListNode actual = atn.addTwoNumbers((AddTwoNumbers.ListNode) inputNumberOne.get(i), (AddTwoNumbers.ListNode) inputNumberTwo.get(i));
            assertEquals(result.get(i), actual);
        }
    }

    public static void main(String[] args) {
        AddTwoNumbersAbstractTest a = new AddTwoNumbersAbstractTest();
        a.initializeData();
        for(List<Object> l: a.dataList){
            System.out.println(l);
        }
    }
}
