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
            String word = entry.getWord().toLowerCase();
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
            String word;
            String[] cmdSplit;
            cmdCount++; //Increases count at beginning of loop to replicate Search [x]

            System.out.print("Search [" + cmdCount + "]: ");
            userInput = in.nextLine();
            cmdSplit = userInput.split(" ");
            if(cmdSplit.length > 0) {
                word = cmdSplit[0].toLowerCase();
            }
            else {
                word = userInput;
            }
            System.out.println("   |");

            if(userInput.equalsIgnoreCase("!help") || userInput.equals("") || userInput.equals(" ")) { // Blank or !help check
                System.out.println("PARAMETER HOW-TO, please enter:" + "\n"
                + "1. A search key -then 2. An optional part of speech -then" + "\n" 
                + "3. An optional 'distinct' -then 4. An optional 'reverse'"
                );
            }
            else if(userInput.equalsIgnoreCase("!q") || userInput.equalsIgnoreCase("!quit")) { //Check to end loop
                running = false;
                System.out.println("-----THANK YOU-----");
                break;
            }
            else if(hmap.containsKey(word)) {
                ArrayList<dictData> pull = hmap.get(word);

                for(dictData data : pull) {
                    System.out.println("   " + data);
                }
                //System.out.println(hmap.get(word)); //Drops every def without spacing needs fix
            }
            else if(!hmap.containsKey(word)) {
                System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
            }

            System.out.println("   |");
        }while(running);
    }
}
