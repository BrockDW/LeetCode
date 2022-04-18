package Utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class JHMTemplate {

    public List<List<Object>> dataList;
    public String questionName;
    public int iterationSize;

    public void initializeData() {
        dataList = new ArrayList<>();
        try {
            int lineCounter = 0;
            File myObj = new File("src/test/java/testData/"+questionName+"Test.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int lineCounterModulo = lineCounter % iterationSize;

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
