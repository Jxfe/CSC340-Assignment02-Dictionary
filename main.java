import java.util.*;

public class main {
    public static void main(String [] args) {
        int cmdCount = 0;
        int keywords = 0;
        int definitions = 0;
        boolean running = true;
        int  testCount = 0;

        Scanner in = new Scanner(System.in);

        System.out.println("! Loading data..."); //Load definitions here

        for (dictData entry : dictData.values()) {
            System.out.println(entry);
            testCount++;
        }
        System.out.print(testCount);

        System.out.println("! Loading completed..." + "\n");

        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: 19"); //Needs variable to count keywords.
        System.out.println("----- Definitions: 61" + "\n"); // Needs variable to count definitions replace num

        do { // Loop to allow interactive search
            String userInput;
            cmdCount++; //Increases count at beginning of loop to replicate Search [x]

            System.out.print("Search [" + cmdCount + "]: ");
            //userInput = in.nextLine();

            running = false;
        }while(running);
    }
}
