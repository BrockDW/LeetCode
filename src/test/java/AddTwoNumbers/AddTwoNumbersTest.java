package AddTwoNumbers;

import Solution.AddTwoNumbers;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@State(Scope.Thread)
public class AddTwoNumbersTest {
    ArrayList<AddTwoNumbers.ListNode> inputNumberOne;
    ArrayList<AddTwoNumbers.ListNode> inputNumberTwo;

    ArrayList<AddTwoNumbers.ListNode> result;

    public void initializeData(){
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
                if(lineCounterModulo == 0) {
                    inputNumberOne.add(resultListNode.next);
                }else if (lineCounterModulo == 1){
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

        System.out.println(inputNumberOne);
        System.out.println(inputNumberTwo);
        System.out.println(result);
    }

    public static void main(String[] args) {
        AddTwoNumbersTest atnt = new AddTwoNumbersTest();
        atnt.initializeData();
    }
}
