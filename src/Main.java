import util.ReadFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter File Location: \n");
        String fileLocation = br.readLine();
        ReadFile readFile = new ReadFile();
        int maxCost = readFile.readTxtFile(fileLocation);
        System.out.printf("Maximum Cost is: %d%n",maxCost);
    }
}
