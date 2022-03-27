import Solution.AddTwoNumbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

abstract class JHMTemplate {
    private List<List<Object>> inputList;
    private List<List<Object>> outputList;

    private String questionName;

//    private int inputIndexEnd;
//    private int outputIndexEnd;
    private Map<Integer, String> indexAndType;


    public void initializeData() {
        inputList = new ArrayList<>();
        outputList = new ArrayList<>();
        try {
            int lineCounter = 0;
            File myObj = new File("src/test/java/AddTwoNumbers/"+questionName+"Test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int lineCounterModulo = lineCounter % indexAndType.size();
                String[] splitedInt = data.split(",");

                AddTwoNumbers.ListNode resultListNode = new AddTwoNumbers.ListNode();
                AddTwoNumbers.ListNode start = resultListNode;
                for (String s : splitedInt) {
                    AddTwoNumbers.ListNode next = new AddTwoNumbers.ListNode(Integer.parseInt(s));
                    start.next = next;
                    start = next;
                }


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

}
