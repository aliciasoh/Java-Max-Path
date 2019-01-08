package util;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by 1567160 on 1/8/2019.
 */
public class ReadFile {

    public static int index = 0;
    public static int total = 0;

    public static int readTxtFile(String fileLocation) throws IOException {
        Path filePath = Paths.get(fileLocation);
        Scanner scanner = new Scanner(filePath);
        ReadFile readFile = new ReadFile();
        while (scanner.hasNext()) {
            String number = scanner.nextLine();
            int highestNum = readFile.getHighestNumber(number, index);
            total = total + highestNum;
        }
        return total;
    }

    public static int getHighestNumber(String line, int indexPassed) {
        String stringToSplit = line;
        String[] stringArr;
        String delimiter = " ";
        ReadFile readFile = new ReadFile();
        stringArr = stringToSplit.split(delimiter);
        int[] array = Arrays.asList(stringArr).stream().mapToInt(Integer::parseInt).toArray();

        if(array.length == 1){
            return Arrays.stream(array).max().getAsInt();
        }
        else{
            int finalArr[] = {array[indexPassed], array[indexPassed + 1]};
            int addNewIndex = readFile.getIndexOfLargest(finalArr);
            index = index + addNewIndex;
            return Arrays.stream(finalArr).max().getAsInt();
        }
    }

    public static int getIndexOfLargest( int[] array ){
        int largest = 0;
        for ( int i = 1; i < array.length; i++ ){
            if ( array[i] > array[largest] ) largest = i;
        }
        return largest;
    }

}
