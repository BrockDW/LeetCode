package Contest.twoEightThree;

import java.util.ArrayList;
import java.util.List;

// Cells in a Range on an Excel Sheet
public class CellsInARange {
    public static List<String> cellsInRange(String s) {
        List<String> result = new ArrayList<>();
        if (s.equals("")){
            return result;
        }
        char col1 = s.charAt(0);
        char row1 = s.charAt(1);
        char col2 = s.charAt(3);
        char row2 = s.charAt(4);
        for (char i = col1; i <= col2; i++){
            for (char j = row1; j <= row2; j++){
                result.add(String.valueOf(i) + j);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        cellsInRange("A1:F1");
        System.out.println(cellsInRange("K1:L2"));
    }
}
