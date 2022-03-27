import Solution.AddTwoNumbers;

import javax.swing.text.StyledEditorKit;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

abstract class JHMTemplate {
    private List<List<Object>> dataList;

    private String questionName;

//    private int inputIndexEnd;
//    private int outputIndexEnd;
    private Map<Integer, Boolean> indexAndType;

    public JHMTemplate(List<List<Object>> dataList, String questionName, Map<Integer, Boolean> indexAndType) {
        this.dataList = dataList;
        this.questionName = questionName;
        this.indexAndType = indexAndType;
    }

    public void initializeData() {
        dataList = new ArrayList<>();
        try {
            int lineCounter = 0;
            File myObj = new File("src/test/java/AddTwoNumbers/"+questionName+"Test.txt");
            Scanner myReader = new Scanner(myObj);
//            ArrayList<Object>
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int lineCounterModulo = lineCounter % indexAndType.size();

                Object curLineToObj = lineToObject(data, lineCounterModulo);

                try {
                    dataList.get(lineCounterModulo).add(curLineToObj);
                } catch (Exception e){
                    dataList.add(new ArrayList<>());
                    dataList.get(lineCounterModulo).add(curLineToObj);
                }

                lineCounter++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public abstract Object lineToObject(String line, int lineCountMod);

}
