import java.util.*;

public class Dictionary {
    public static void main(String [] args) {
        int cmdCount = 0;
        int keywords = 0;
        int definitions = 0;
        boolean running = true;
        Scanner in = new Scanner(System.in);
        HashMap<String, ArrayList<dictData>> hmap = new HashMap<String, ArrayList<dictData>>();

        System.out.println("! Loading data..."); 

        for (dictData entry : dictData.values()) {
            String word = entry.getWord();
            ArrayList<dictData> defs;

            if(hmap.containsKey(word)) { //Checks if word is already in Dictonary(HashMap)
                defs = hmap.get(word);
                defs.add(entry);
            }
            else { // If it is adds definitions and increases keyword count
                defs = new ArrayList<dictData>();
                defs.add(entry);
                keywords++;
            }

            hmap.put(word, defs);
            definitions++;

            //System.out.println("Count " + keywords + " : " + entry.toString()); //Test Counts
        }

        System.out.println("! Loading completed..." + "\n");

        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + keywords); //Needs variable to count keywords.
        System.out.println("----- Definitions: " + definitions + "\n"); 

        do { // Loop to allow interactive search
            String userInput;
            cmdCount++; //Increases count at beginning of loop to replicate Search [x]

            System.out.print("Search [" + cmdCount + "]: ");
            //userInput = in.nextLine();

            running = false;
        }while(running);
    }
}
