package MedianTwoSortedArrayTest;

import Solution.hard.MedianTwoSortedArray;
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
        int[] inputOne = {0,1,3,3,5,6,6,7};
        int[] inputTwo = {4};
        assertEquals(4, mtsa.findMedianSortedArrays(inputOne, inputTwo), 0.01);

        int[] inputOne1 = {1,3,3,5,6,6,7};
        int[] inputTwo1 = {4};
        assertEquals(4.5, mtsa.findMedianSortedArrays(inputOne1, inputTwo1), 0.01);

        int[] inputOne2 = {1,2,2,3,6,6,7};
        int[] inputTwo2 = {5};
        assertEquals(4, mtsa.findMedianSortedArrays(inputOne2, inputTwo2), 0.01);

        int[] inputOne3 = {1,3,3,5,6,6,7};
        int[] inputTwo3 = {8};
        assertEquals(5.5, mtsa.findMedianSortedArrays(inputOne3, inputTwo3), 0.01);

        int[] inputOne4 = {1,3,3,5,6,6,7};
        int[] inputTwo4 = {8};
        assertEquals(5.5, mtsa.findMedianSortedArrays(inputOne3, inputTwo3), 0.01);

        int[] inputOne5 = {1,3,3,5,6,6,7};
        int[] inputTwo5 = {8};
        assertEquals(5.5, mtsa.findMedianSortedArrays(inputOne3, inputTwo3), 0.01);
    }

    @Test
    public void specialCaseTestTwo(){
        int[] inputOne = {1,2};
        int[] inputTwo = {3};
        assertEquals(2, mtsa.findMedianSortedArrays(inputOne, inputTwo), 0.01);
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
