package MedianTwoSortedArrayTest;

import Solution.MedianTwoSortedArray;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class MedianTwoSortedArrayTest {
    ArrayList<Integer[]> inputOne;
    ArrayList<Integer[]> inputTwo;
    ArrayList<Double> result;
    MedianTwoSortedArray mtsa = new MedianTwoSortedArray();

    public void initializeData() {
        inputOne = new ArrayList<>();
        inputTwo = new ArrayList<>();
        result = new ArrayList<>();
        try {
            int lineCounter = 0;
            File myObj = new File(
                    "src/test/java/MedianTwoSortedArrayTest/medianTwoSortedArrayTest.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                int lineCounterModulo = lineCounter % 3;
                if (lineCounterModulo != 2) {
                    String[] splitedInt = data.split(",");
                    Integer[] parsedInt = new Integer[splitedInt.length];
                    for(int i = 0; i < splitedInt.length; i++){
                        parsedInt[i] = Integer.parseInt(splitedInt[i]);
                    }
                    if (lineCounterModulo == 0){
                        inputOne.add(parsedInt);
                    } else {
                        inputTwo.add(parsedInt);
                    }
                } else {
                    result.add(Double.parseDouble(data));
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
    public void specialCaseTest(){
        int[] inputOne = {1,2,3,4};
        int[] inputTwo = {1};
        assertEquals(2, mtsa.findMedianSortedArrays(inputOne, inputTwo), 0.01);
    }

    @Test
    public void specialCaseTestTwo(){
        int[] inputOne = {1,2};
        int[] inputTwo = {1};
        assertEquals(1, mtsa.findMedianSortedArrays(inputOne, inputTwo), 0.01);
    }

    @Test
    public void specialCaseTestThree(){
        int[] inputOne = {2};
        int[] inputTwo = {3};
        assertEquals(2.5, mtsa.findMedianSortedArrays(inputOne, inputTwo), 0.01);
    }

    public static void main(String[] args) {
        MedianTwoSortedArrayTest test = new MedianTwoSortedArrayTest();
        test.initializeData();
    }
}
